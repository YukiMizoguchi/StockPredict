package com.ciservice.app.common.json.pojo;

import java.util.Set;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author YukiMizoguchi
 *
 */
public class StockData {

  protected static Logger logger = Logger.getLogger(StockData.class);

  @JsonProperty("japan-all-stock-data")
  public Set<String[]> japanAllStockData;

  /**
   * @see java.lang.Object#toString()
   * @return
   */
  @Override
  public String toString() {
    return "StockData [japanAllStockData=" + japanAllStockData + "]";
  }

}
