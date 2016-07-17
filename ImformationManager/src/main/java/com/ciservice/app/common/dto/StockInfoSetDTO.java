package com.ciservice.app.common.dto;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author YukiMizoguchi
 *
 */
public class StockInfoSetDTO {

  protected static Logger logger = Logger.getLogger(StockInfoSetDTO.class);

  private List<StockPriceDTO> stockPriceList;

  private List<StockDataDTO> stockDataList;

  /**
   * @return stockPriceList
   */
  public List<StockPriceDTO> getStockPriceList() {
    return stockPriceList;
  }

  /**
   * @param stockPriceList セットする stockPriceList
   */
  public void setStockPriceList(List<StockPriceDTO> stockPriceList) {
    this.stockPriceList = stockPriceList;
  }

  /**
   * @return stockDataList
   */
  public List<StockDataDTO> getStockDataList() {
    return stockDataList;
  }

  /**
   * @param stockDataList セットする stockDataList
   */
  public void setStockDataList(List<StockDataDTO> stockDataList) {
    this.stockDataList = stockDataList;
  }

  /*
   * (非 Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "StockInfoSetDTO [stockPriceList=" + stockPriceList + ", stockDataList=" + stockDataList
        + "]";
  }

}
