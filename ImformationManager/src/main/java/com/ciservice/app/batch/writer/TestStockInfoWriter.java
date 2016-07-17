package com.ciservice.app.batch.writer;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("testStockInfoWriter")
public class TestStockInfoWriter implements ItemWriter<StockInfo> {

  protected static Logger logger = Logger.getLogger(TestStockInfoWriter.class);

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
   */
  @Override
  public void write(List<? extends StockInfo> items) throws Exception {


    for (final StockInfo stockInfo : items) {
      System.out.println(stockInfo.toString());

    }


  }


}
