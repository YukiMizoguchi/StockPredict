package com.ciservice.app.batch.reader;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.constant.SGConst;
import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.db.mongodb.repos.StockInfoRepository;
import com.ciservice.app.common.exception.BusinessLogicException;
import com.ciservice.app.common.exception.SystemErrorException;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reNonResultStockInfoReader")
public class ReNonDayResultStockInfoReader implements ItemReader<StockInfo> {

  protected static Logger logger = Logger.getLogger(ReNonDayResultStockInfoReader.class);


  @Value("${common.date.skipRsltDay}")
  private int skipRsltDay;

  /**
   * Reads next record from mongoDB
   */
  public StockInfo read() throws Exception {

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

    final StockInfo stockInfo;
    try {
      // rsltDayChkDateがSG日より前の情報を1件取得
      stockInfo = stockInfoRepos.findOneByRsltDayChkDateBefore(chkDateBefore);

    } catch (Exception exception) {
      throw new SystemErrorException("IM4103:DBエラー発生（参照）", exception);
    } finally {
      ((ConfigurableApplicationContext) ctxStockInfoRef).close();
    }

    if (stockInfo == null) {
      throw new BusinessLogicException("IM1101:参照データなし");
    }

    return stockInfo;

  }

}
