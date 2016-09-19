package com.ciservice.app.common.dto;

import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author YukiMizoguchi
 *
 */
public class StockInfoSetDTO {

  protected static Logger logger = Logger.getLogger(StockInfoSetDTO.class);

  private Set<StockPriceDTO> stockPriceSet;

  private Set<StockDataDTO> stockDataSet;

  /**
   * @return stockPriceSet
   */
  public Set<StockPriceDTO> getStockPriceSet() {
    return stockPriceSet;
  }

  /**
   * @param stockPriceSet セットする stockPriceSet
   */
  public void setStockPriceSet(Set<StockPriceDTO> stockPriceSet) {
    this.stockPriceSet = stockPriceSet;
  }

  /**
   * @return stockDataSet
   */
  public Set<StockDataDTO> getStockDataSet() {
    return stockDataSet;
  }

  /**
   * @param stockDataSet セットする stockDataSet
   */
  public void setStockDataSet(Set<StockDataDTO> stockDataSet) {
    this.stockDataSet = stockDataSet;
  }

  /*
   * (非 Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "StockInfoSetDTO [stockPriceSet=" + stockPriceSet + ", stockDataSet=" + stockDataSet
        + "]";
  }

}
