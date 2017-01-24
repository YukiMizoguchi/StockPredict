package com.ciservice.app.common.json.pojo;

import java.util.Set;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author YukiMizoguchi
 *
 */
public class StockPrices {

  protected static Logger logger = Logger.getLogger(StockPrices.class);

  @JsonProperty("japan-all-stock-prices")
  public Set<String[]> japanAllAtockPrices;

  /**
   * @see java.lang.Object#toString()
   * @return
   */
  @Override
  public String toString() {
    return "StockPrices [japanAllAtockPrices=" + japanAllAtockPrices + "]";
  }

}
