package com.ciservice.app.common.dto;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author YukiMizoguchi
 *
 */
public class StockDataDTO {

  protected static Logger logger = Logger.getLogger(StockDataDTO.class);

  private String sc;
  private String name;
  private String business;
  private String marcket;
  private Double marketCapt;
  private Double issuedShares;
  private Double dividendYield;
  private Double perShareDividend;
  // CHECKSTYLE:OFF
  private Double pER;
  private Double pBR;
  private Double ePS;
  private Double bPS;
  // CHECKSTYLE:ON
  private Double minPrchAmnt;
  private Double shareUnit;
  private Date highDate;
  private Double highPriceYear;
  private Date lowDate;
  private Double lowPriceYear;

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
   * @return issuedShares
   */
  public Double getIssuedShares() {
    return issuedShares;
  }

  /**
   * @param issuedShares セットする issuedShares
   */
  public void setIssuedShares(Double issuedShares) {
    this.issuedShares = issuedShares;
  }

  /**
   * @return dividendYield
   */
  public Double getDividendYield() {
    return dividendYield;
  }

  /**
   * @param dividendYield セットする dividendYield
   */
  public void setDividendYield(Double dividendYield) {
    this.dividendYield = dividendYield;
  }

  /**
   * @return perShareDividend
   */
  public Double getPerShareDividend() {
    return perShareDividend;
  }

  /**
   * @param perShareDividend セットする perShareDividend
   */
  public void setPerShareDividend(Double perShareDividend) {
    this.perShareDividend = perShareDividend;
  }

  /**
   * @return pER
   */
  public Double getPER() {
    return pER;
  }

  // CHECKSTYLE:OFF
  /**
   * @param pER セットする pER
   */
  public void setPER(Double pER) {
    this.pER = pER;
  }
  // CHECKSTYLE:ON

  /**
   * @return pBR
   */
  public Double getPBR() {
    return pBR;
  }

  // CHECKSTYLE:OFF
  /**
   * @param pBR セットする pBR
   */
  public void setPBR(Double pBR) {
    this.pBR = pBR;
  }
  // CHECKSTYLE:ON

  /**
   * @return ePS
   */
  public Double getEPS() {
    return ePS;
  }

  // CHECKSTYLE:OFF
  /**
   * @param ePS セットする ePS
   */
  public void setEPS(Double ePS) {
    this.ePS = ePS;
  }
  // CHECKSTYLE:ON

  /**
   * @return bPS
   */
  public Double getBPS() {
    return bPS;
  }

  // CHECKSTYLE:OFF
  /**
   * @param bPS セットする bPS
   */
  public void setBPS(Double bPS) {
    this.bPS = bPS;
  }
  // CHECKSTYLE:ON

  /**
   * @return minPrchAmnt
   */
  public Double getMinPrchAmnt() {
    return minPrchAmnt;
  }

  /**
   * @param minPrchAmnt セットする minPrchAmnt
   */
  public void setMinPrchAmnt(Double minPrchAmnt) {
    this.minPrchAmnt = minPrchAmnt;
  }

  /**
   * @return shareUnit
   */
  public Double getShareUnit() {
    return shareUnit;
  }

  /**
   * @param shareUnit セットする shareUnit
   */
  public void setShareUnit(Double shareUnit) {
    this.shareUnit = shareUnit;
  }

  /**
   * @return highDate
   */
  public Date getHighDate() {
    return highDate;
  }

  /**
   * @param highDate セットする highDate
   */
  public void setHighDate(Date highDate) {
    this.highDate = highDate;
  }

  /**
   * @return highPriceYear
   */
  public Double getHighPriceYear() {
    return highPriceYear;
  }

  /**
   * @param highPriceYear セットする highPriceYear
   */
  public void setHighPriceYear(Double highPriceYear) {
    this.highPriceYear = highPriceYear;
  }

  /**
   * @return lowDate
   */
  public Date getLowDate() {
    return lowDate;
  }

  /**
   * @param lowDate セットする lowDate
   */
  public void setLowDate(Date lowDate) {
    this.lowDate = lowDate;
  }

  /**
   * @return lowPriceYear
   */
  public Double getLowPriceYear() {
    return lowPriceYear;
  }

  /**
   * @param lowPriceYear セットする lowPriceYear
   */
  public void setLowPriceYear(Double lowPriceYear) {
    this.lowPriceYear = lowPriceYear;
  }

}
