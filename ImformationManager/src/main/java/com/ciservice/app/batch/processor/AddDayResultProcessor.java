package com.ciservice.app.batch.processor;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
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
@Component("addDayRsltProcessor")
public class AddDayResultProcessor implements ItemProcessor<StockInfo, StockInfo> {

  protected static Logger logger = Logger.getLogger(AddDayResultProcessor.class);


  private final CommonUtil cmnUtil = new CommonUtil();

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
   */
  @Override
  public StockInfo process(StockInfo item) throws Exception {

    // 入力データチェック
    if (item.getSc() == null) {
      return null;
    }

    if (item.getSavedDate() == null) {
      return null;
    }

    if (item.getFixedPrice() == null) {
      return null;
    }

    final double targetPrice = item.getFixedPrice();

    final Date savedDateDay = cmnUtil.getSavedDate(item.getSavedDate());

    // DB使用定義
    ApplicationContext ctxStockInfoRef =
        new GenericXmlApplicationContext(SGConst.PROPERTIES_MONGPDB_BEAN_XML);
    StockInfoRepository stockInfoRepos = ctxStockInfoRef.getBean(StockInfoRepository.class);

    final StockInfo stockInfo = item;
    int intCnt = 1;

    try {

      while (stockInfo.getRsltDay() == null && intCnt < 4) {
        intCnt++;

        // 前日を算出する
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(savedDateDay);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        final String targetDate = cmnUtil.getSavedDate(calendar.getTime());

        final StockInfo stockInfoRef =
            stockInfoRepos.findOneByScAndSavedDate(item.getSc(), targetDate);

        // 対象日の情報が取得できない場合、ループを継続
        if (stockInfoRef == null) {
          continue;
        }

        // 価格が取得できない場合
        if (stockInfoRef.getFixedPrice() == null) {
          throw new SystemErrorException("価格が取得できない");
        }

        final double prePice = stockInfoRef.getFixedPrice();

        if (targetPrice > prePice) {
          // ターゲット価格が前日より高い
          stockInfo.setRsltDay(PredictResult.UP);
        } else if (targetPrice < prePice) {
          // ターゲット価格が前日より低い
          stockInfo.setRsltDay(PredictResult.DOWN);
        } else {
          // ターゲット価格が変化なし
          stockInfo.setRsltDay(PredictResult.KEEP);
        }

      }

    } catch (Exception exception) {
      throw new SystemErrorException("DBエラー発生（参照）", exception);
    } finally {
      ((ConfigurableApplicationContext) ctxStockInfoRef).close();
    }

    // 対象日の情報が取得できなかった場合チェック日時を付与
    if (stockInfo.getRsltDay() == null) {
      stockInfo.setRsltDayChkDate(new Date());
    }

    return stockInfo;

  }


}
