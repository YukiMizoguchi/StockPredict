package com.ciservice.app.batch.writer;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.constant.SGConst;
import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.db.mongodb.repos.StockInfoRepository;
import com.ciservice.app.common.exception.SystemErrorException;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("stockInfoListWriter")
public class StockInfoListWriter implements ItemWriter<List<StockInfo>> {

  protected static Logger logger = Logger.getLogger(StockInfoListWriter.class);

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
   */
  @Override
  public void write(List<? extends List<StockInfo>> items) throws Exception {


    /************************************************************
     * インプットデータ分繰り返し
     ************************************************************/
    for (final List<StockInfo> stockInfos : items) {

      /************************************************************
       * StockInfo格納
       ************************************************************/
      // DB使用定義
      ApplicationContext ctxStockInfoReg =
          new GenericXmlApplicationContext(SGConst.PROPERTIES_MONGPDB_BEAN_XML);
      StockInfoRepository stockInfoRepos = ctxStockInfoReg.getBean(StockInfoRepository.class);

      try {

        // StockInfo分更新
        for (final StockInfo stockInfo : stockInfos) {
          // DB更新
          final StockInfo savedStockInfo = stockInfoRepos.save(stockInfo);
          final StringBuilder resultString = new StringBuilder();

          if (savedStockInfo == null) {
            resultString.append("更新なし");

          } else {
            resultString.append("正常更新");

          }

          resultString.append(" sc=");
          resultString.append(stockInfo.getSc());
          resultString.append(" savedDate=");
          resultString.append(stockInfo.getSavedDate());

          System.out.println(resultString.toString());

        }

      } catch (Exception exception) {
        throw new SystemErrorException("IM4102:DBエラー発生（更新）", exception);
      } finally {
        ((ConfigurableApplicationContext) ctxStockInfoReg).close();
      }

    }

  }


}