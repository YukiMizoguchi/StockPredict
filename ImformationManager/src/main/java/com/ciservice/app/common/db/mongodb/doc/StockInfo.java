package com.ciservice.app.common.db.mongodb.doc;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ciservice.app.common.enumeration.PredictResult;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author YukiMizoguchi
 *
 */
@Document(collection = "stockinfo")
public class StockInfo {

  @Id
  private String id;
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
  private PredictResult rsltDay;
  private Date rsltDayChkDate;
  private PredictResult rsltWeek;
  private Date rsltWeekChkDate;
  private PredictResult rsltMonth;
  private Date rsltMonthChkDate;
  private PredictResult predictDay;
  private PredictResult predictWeek;
  private PredictResult predictMonth;

  /**
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id sets id
   */
  public void setId(String id) {
    this.id = id;
  }

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
  @JsonProperty("pER")
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
  @JsonProperty("pBR")
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
  @JsonProperty("ePS")
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
  @JsonProperty("bPS")
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

  /**
   * @return rsltDay
   */
  public PredictResult getRsltDay() {
    return rsltDay;
  }

  /**
   * @param rsltDay sets rsltDay
   */
  public void setRsltDay(PredictResult rsltDay) {
    this.rsltDay = rsltDay;
  }

  /**
   * @return rsltDayChkDate
   */
  public Date getRsltDayChkDate() {
    return rsltDayChkDate;
  }

  /**
   * @param rsltDayChkDate sets rsltDayChkDate
   */
  public void setRsltDayChkDate(Date rsltDayChkDate) {
    this.rsltDayChkDate = rsltDayChkDate;
  }

  /**
   * @return rsltWeek
   */
  public PredictResult getRsltWeek() {
    return rsltWeek;
  }

  /**
   * @param rsltWeek sets rsltWeek
   */
  public void setRsltWeek(PredictResult rsltWeek) {
    this.rsltWeek = rsltWeek;
  }

  /**
   * @return rsltWeekChkDate
   */
  public Date getRsltWeekChkDate() {
    return rsltWeekChkDate;
  }

  /**
   * @param rsltWeekChkDate sets rsltWeekChkDate
   */
  public void setRsltWeekChkDate(Date rsltWeekChkDate) {
    this.rsltWeekChkDate = rsltWeekChkDate;
  }

  /**
   * @return rsltMonth
   */
  public PredictResult getRsltMonth() {
    return rsltMonth;
  }

  /**
   * @param rsltMonth sets rsltMonth
   */
  public void setRsltMonth(PredictResult rsltMonth) {
    this.rsltMonth = rsltMonth;
  }

  /**
   * @return rsltMonthChkDate
   */
  public Date getRsltMonthChkDate() {
    return rsltMonthChkDate;
  }

  /**
   * @param rsltMonthChkDate sets rsltMonthChkDate
   */
  public void setRsltMonthChkDate(Date rsltMonthChkDate) {
    this.rsltMonthChkDate = rsltMonthChkDate;
  }

  /**
   * @return predictDay
   */
  public PredictResult getPredictDay() {
    return predictDay;
  }

  /**
   * @param predictDay sets predictDay
   */
  public void setPredictDay(PredictResult predictDay) {
    this.predictDay = predictDay;
  }

  /**
   * @return predictWeek
   */
  public PredictResult getPredictWeek() {
    return predictWeek;
  }

  /**
   * @param predictWeek sets predictWeek
   */
  public void setPredictWeek(PredictResult predictWeek) {
    this.predictWeek = predictWeek;
  }

  /**
   * @return predictMonth
   */
  public PredictResult getPredictMonth() {
    return predictMonth;
  }

  /**
   * @param predictMonth sets predictMonth
   */
  public void setPredictMonth(PredictResult predictMonth) {
    this.predictMonth = predictMonth;
  }

  /*
   * (非 Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "StockInfo [id=" + id + ", sc=" + sc + ", savedDate=" + savedDate + ", name=" + name
        + ", business=" + business + ", marcket=" + marcket + ", date=" + date + ", fixedPrice="
        + fixedPrice + ", dayBeforeDiff=" + dayBeforeDiff + ", dayBeforeRatio=" + dayBeforeRatio
        + ", dayBeforePrice=" + dayBeforePrice + ", openPrice=" + openPrice + ", highPrice="
        + highPrice + ", lowPrice=" + lowPrice + ", volume=" + volume + ", tradingValue="
        + tradingValue + ", marketCapt=" + marketCapt + ", widthLowLmt=" + widthLowLmt
        + ", widthHighLmt=" + widthHighLmt + ", issuedShares=" + issuedShares + ", dividendYield="
        + dividendYield + ", perShareDividend=" + perShareDividend + ", pER=" + pER + ", pBR=" + pBR
        + ", ePS=" + ePS + ", bPS=" + bPS + ", minPrchAmnt=" + minPrchAmnt + ", shareUnit="
        + shareUnit + ", highDate=" + highDate + ", highPriceYear=" + highPriceYear + ", lowDate="
        + lowDate + ", lowPriceYear=" + lowPriceYear + ", rsltDay=" + rsltDay + ", rsltDayChkDate="
        + rsltDayChkDate + ", rsltWeek=" + rsltWeek + ", rsltWeekChkDate=" + rsltWeekChkDate
        + ", rsltMonth=" + rsltMonth + ", rsltMonthChkDate=" + rsltMonthChkDate + ", predictDay="
        + predictDay + ", predictWeek=" + predictWeek + ", predictMonth=" + predictMonth + "]";
  }


}
