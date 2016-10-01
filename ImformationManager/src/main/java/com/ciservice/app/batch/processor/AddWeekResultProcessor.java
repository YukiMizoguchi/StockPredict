package com.ciservice.app.batch.processor;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.constant.SGConst;
import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.db.mongodb.repos.StockInfoRepository;
import com.ciservice.app.common.enumeration.PredictResult;
import com.ciservice.app.common.exception.SystemErrorException;
import com.ciservice.app.common.util.CommonUtil;

/**
 * @author YukiMizoguchi
 *
 */
@Component("addWeekRsltProcessor")
public class AddWeekResultProcessor implements ItemProcessor<Set<StockInfo>, Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(AddWeekResultProcessor.class);

  @Value("${common.date.skipRsltDay}")
  private int skipRsltDay;

  private final CommonUtil cmnUtil = new CommonUtil();

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
   */
  @Override
  public Set<StockInfo> process(Set<StockInfo> item) throws Exception {

    if (item == null) {
      return null;
    }

    final Set<StockInfo> stockInfoSet = new HashSet<>();

    // DB使用定義
    ApplicationContext ctxStockInfoRef =
        new GenericXmlApplicationContext(SGConst.PROPERTIES_MONGPDB_BEAN_XML);
    final StockInfoRepository stockInfoRepos = ctxStockInfoRef.getBean(StockInfoRepository.class);

    try {

      for (final StockInfo stockInfo : item) {

        // 入力データチェック
        if (stockInfo.getSc() == null) {
          return null;
        }

        if (stockInfo.getSavedDate() == null) {
          return null;
        }


        if (stockInfo.getFixedPrice() == null) {
          continue;
        }

        final Date savedDateDay = cmnUtil.getSavedDate(stockInfo.getSavedDate());


        int intCnt = 0;


        while (stockInfo.getRsltWeek() == null && intCnt < skipRsltDay) {
          intCnt++;

          // 前週日を算出する
          final Calendar calendar = Calendar.getInstance();
          calendar.setTime(savedDateDay);
          calendar.add(Calendar.DAY_OF_MONTH, intCnt + 6);
          final String targetDate = cmnUtil.getSavedDate(calendar.getTime());

          final StockInfo stockInfoRef =
              stockInfoRepos.findOneByScAndSavedDate(stockInfo.getSc(), targetDate);

          // 対象日の情報が取得できない場合、ループを継続
          if (stockInfoRef == null) {
            continue;
          }

          // 価格が取得できない場合
          if (stockInfoRef.getFixedPrice() == null) {
            // throw new SystemErrorException("価格が取得できない");
            continue;
          }

          final double fixedPrice = stockInfo.getFixedPrice();
          final double targetFixedPrice = stockInfoRef.getFixedPrice();
          final double beforeRatio = (targetFixedPrice - fixedPrice) / fixedPrice * 100;

          if (beforeRatio >= 30) {
            // ターゲット価格が対象日より高い(暴騰)
            stockInfo.setRsltWeek(PredictResult.HUP);
          } else if (beforeRatio >= 10) {
            // ターゲット価格が対象日より高い
            stockInfo.setRsltWeek(PredictResult.MUP);
          } else if (beforeRatio >= 5) {
            // ターゲット価格が対象日より少し高い
            stockInfo.setRsltWeek(PredictResult.UP);
          } else if (beforeRatio > -5) {
            // ターゲット価格が対象日とほぼ同じ
            stockInfo.setRsltWeek(PredictResult.KEEP);
          } else if (beforeRatio > -10) {
            // ターゲット価格が対象日より少し低い
            stockInfo.setRsltWeek(PredictResult.DOWN);
          } else if (beforeRatio > -30) {
            // ターゲット価格が対象日より低い
            stockInfo.setRsltWeek(PredictResult.MDOWN);
          } else {
            // ターゲット価格が対象日より低い（暴落）
            stockInfo.setRsltWeek(PredictResult.HDOWN);
          }

        }

        // 対象日の情報が取得できなかった場合チェック日時を付与
        if (stockInfo.getRsltWeek() == null) {
          stockInfo.setRsltWeekChkDate(new Date());
        }

        stockInfoSet.add(stockInfo);

      }


    } catch (Exception exception) {
      throw new SystemErrorException("DBエラー発生（参照）", exception);
    } finally {
      ((ConfigurableApplicationContext) ctxStockInfoRef).close();
    }

    return stockInfoSet;

  }


}
