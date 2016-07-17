package com.ciservice.app.common.json.pojo;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author YukiMizoguchi
 *
 */
public class StockData {

  protected static Logger logger = Logger.getLogger(StockData.class);

  public List<String[]> aaData;

  /*
   * (非 Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "StockDataList [aaData=" + aaData + "]";
  }

}
