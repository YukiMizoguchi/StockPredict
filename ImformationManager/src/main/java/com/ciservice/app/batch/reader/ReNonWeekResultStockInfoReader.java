package com.ciservice.app.batch.reader;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.constant.SGConst;
import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.db.mongodb.repos.StockInfoRepository;
import com.ciservice.app.common.exception.SystemErrorException;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reNonWeekResultStockInfoReader")
public class ReNonWeekResultStockInfoReader implements ItemReader<Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(ReNonWeekResultStockInfoReader.class);


  @Value("${common.date.skipRsltDay}")
  private int skipRsltDay;

  @Value("${common.num.getnonrsltrcord}")
  private int limit;

  /**
   * Reads next record from mongoDB
   */
  public Set<StockInfo> read() throws Exception {

    /************************************************************
     * チェック日取得
     ************************************************************/

    final Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.DAY_OF_MONTH, -skipRsltDay);
    final Date chkDateBefore = calendar.getTime();

    /************************************************************
     * StockInfo取得
     ************************************************************/
    // DB使用定義
    ApplicationContext ctxStockInfoRef =
        new GenericXmlApplicationContext(SGConst.PROPERTIES_MONGPDB_BEAN_XML);
    StockInfoRepository stockInfoRepos = ctxStockInfoRef.getBean(StockInfoRepository.class);

    Set<StockInfo> stockInfoSet;
    try {
      // rsltWeekChkDateがSG日より前の情報を1件取得
      // stockInfo = stockInfoRepos.findOneByRsltWeekChkDateBefore(chkDateBefore);
      // rsltWeekがNULLの情報を数件取得
      final Page<StockInfo> stockInfoPage =
          stockInfoRepos.findByRsltWeekChkDateBefore(new PageRequest(0, limit), chkDateBefore);

      stockInfoSet = new HashSet<StockInfo>(stockInfoPage.getContent());

    } catch (Exception exception) {
      throw new SystemErrorException("IM4103:DBエラー発生（参照）", exception);
    } finally {
      ((ConfigurableApplicationContext) ctxStockInfoRef).close();
    }

    if (stockInfoSet.isEmpty()) {
      logger.info("週次結果の設定完了");
      return null;
    }

    return stockInfoSet;


  }

}
