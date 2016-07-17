package com.ciservice.app.common.dto;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author YukiMizoguchi
 *
 */
public class StockPriceDTO {

  protected static Logger logger = Logger.getLogger(StockPriceDTO.class);

  private String sc;
  private String savedDate;
  private String name;
  private String business;
  private String marcket;
  private Date date;
  private Double fixedPrice;
  private Double dayBeforeDiff;
  private Double dayBeforeRatio;
  private Double dayBeforePrice;
  private Double openPrice;
  private Double highPrice;
  private Double lowPrice;
  private Double volume;
  private Double tradingValue;
  private Double marketCapt;
  private Double widthLowLmt;
  private Double widthHighLmt;

  /**
   * @return sc
   */
  public String getSc() {
    return sc;
  }

  /**
   * @param sc セットする sc
   */
  public void setSc(String sc) {
    this.sc = sc;
  }

  /**
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name セットする name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return business
   */
  public String getBusiness() {
    return business;
  }

  /**
   * @param business セットする business
   */
  public void setBusiness(String business) {
    this.business = business;
  }

  /**
   * @return marcket
   */
  public String getMarcket() {
    return marcket;
  }

  /**
   * @param marcket セットする marcket
   */
  public void setMarcket(String marcket) {
    this.marcket = marcket;
  }

  /**
   * @return date
   */
  public Date getDate() {
    return date;
  }

  /**
   * @param date セットする date
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * @return fixedPrice
   */
  public Double getFixedPrice() {
    return fixedPrice;
  }

  /**
   * @param fixedPrice セットする fixedPrice
   */
  public void setFixedPrice(Double fixedPrice) {
    this.fixedPrice = fixedPrice;
  }

  /**
   * @return dayBeforeDiff
   */
  public Double getDayBeforeDiff() {
    return dayBeforeDiff;
  }

  /**
   * @param dayBeforeDiff セットする dayBeforeDiff
   */
  public void setDayBeforeDiff(Double dayBeforeDiff) {
    this.dayBeforeDiff = dayBeforeDiff;
  }

  /**
   * @return dayBeforeRatio
   */
  public Double getDayBeforeRatio() {
    return dayBeforeRatio;
  }

  /**
   * @param dayBeforeRatio セットする dayBeforeRatio
   */
  public void setDayBeforeRatio(Double dayBeforeRatio) {
    this.dayBeforeRatio = dayBeforeRatio;
  }

  /**
   * @return dayBeforePrice
   */
  public Double getDayBeforePrice() {
    return dayBeforePrice;
  }

  /**
   * @param dayBeforePrice セットする dayBeforePrice
   */
  public void setDayBeforePrice(Double dayBeforePrice) {
    this.dayBeforePrice = dayBeforePrice;
  }

  /**
   * @return openPrice
   */
  public Double getOpenPrice() {
    return openPrice;
  }

  /**
   * @param openPrice セットする openPrice
   */
  public void setOpenPrice(Double openPrice) {
    this.openPrice = openPrice;
  }

  /**
   * @return highPrice
   */
  public Double getHighPrice() {
    return highPrice;
  }

  /**
   * @param highPrice セットする highPrice
   */
  public void setHighPrice(Double highPrice) {
    this.highPrice = highPrice;
  }

  /**
   * @return lowPrice
   */
  public Double getLowPrice() {
    return lowPrice;
  }

  /**
   * @param lowPrice セットする lowPrice
   */
  public void setLowPrice(Double lowPrice) {
    this.lowPrice = lowPrice;
  }

  /**
   * @return volume
   */
  public Double getVolume() {
    return volume;
  }

  /**
   * @param volume セットする volume
   */
  public void setVolume(Double volume) {
    this.volume = volume;
  }

  /**
   * @return tradingValue
   */
  public Double getTradingValue() {
    return tradingValue;
  }

  /**
   * @param tradingValue セットする tradingValue
   */
  public void setTradingValue(Double tradingValue) {
    this.tradingValue = tradingValue;
  }

  /**
   * @return marketCapt
   */
  public Double getMarketCapt() {
    return marketCapt;
  }

  /**
   * @param marketCapt セットする marketCapt
   */
  public void setMarketCapt(Double marketCapt) {
    this.marketCapt = marketCapt;
  }

  /**
   * @return widthLowLmt
   */
  public Double getWidthLowLmt() {
    return widthLowLmt;
  }

  /**
   * @param widthLowLmt セットする widthLowLmt
   */
  public void setWidthLowLmt(Double widthLowLmt) {
    this.widthLowLmt = widthLowLmt;
  }

  /**
   * @return widthHighLmt
   */
  public Double getWidthHighLmt() {
    return widthHighLmt;
  }

  /**
   * @param widthHighLmt セットする widthHighLmt
   */
  public void setWidthHighLmt(Double widthHighLmt) {
    this.widthHighLmt = widthHighLmt;
  }

  /**
   * @return savedDate
   */
  public String getSavedDate() {
    return savedDate;
  }

  /**
   * @param savedDate sets savedDate
   */
  public void setSavedDate(String savedDate) {
    this.savedDate = savedDate;
  }

  /*
   * (非 Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "StockPriceDTO [sc=" + sc + ", savedDate=" + savedDate + ", name=" + name + ", business="
        + business + ", marcket=" + marcket + ", date=" + date + ", fixedPrice=" + fixedPrice
        + ", dayBeforeDiff=" + dayBeforeDiff + ", dayBeforeRatio=" + dayBeforeRatio
        + ", dayBeforePrice=" + dayBeforePrice + ", openPrice=" + openPrice + ", highPrice="
        + highPrice + ", lowPrice=" + lowPrice + ", volume=" + volume + ", tradingValue="
        + tradingValue + ", marketCapt=" + marketCapt + ", widthLowLmt=" + widthLowLmt
        + ", widthHighLmt=" + widthHighLmt + "]";
  }

}
