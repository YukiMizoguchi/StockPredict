package com.ciservice.app.common.json.pojo;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author YukiMizoguchi
 *
 */
public class StockPrices {

  protected static Logger logger = Logger.getLogger(StockPrices.class);

  public List<String[]> aaData;

  /*
   * (非 Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "StockPriceList [aaData=" + aaData + "]";
  }

}
