package com.ciservice.app.common.dto;

/**
 * @author YukiMizoguchi
 *
 */
public class StockInfoPredictDTO {

  private String id;
  private String sc;
  private String savedDate;
  // CHECKSTYLE:OFF
  private int date_year;
  private int date_month;
  private int date_day;
  private int date_weekday;
  // CHECKSTYLE:ON
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
  // CHECKSTYLE:OFF
  private int highDate_diff;
  private int highDate_year;
  private int highDate_month;
  private int highDate_day;
  private int highDate_weekday;
  // CHECKSTYLE:ON
  private Double highPriceYear;
  // CHECKSTYLE:OFF
  private int lowDate_diff;
  private int lowDate_year;
  private int lowDate_month;
  private int lowDate_day;
  private int lowDate_weekday;
  // CHECKSTYLE:ON
  private Double lowPriceYear;
  private int predictDay;

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
   * @param sc sets sc
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
   * @return date_year
   */
  public int getDate_year() {
    return date_year;
  }

  /**
   * @param date_year sets date_year
   */
  // CHECKSTYLE:OFF
  public void setDate_year(int date_year) {
    // CHECKSTYLE:ON
    this.date_year = date_year;
  }

  /**
   * @return date_month
   */
  public int getDate_month() {
    return date_month;
  }

  /**
   * @param date_month sets date_month
   */
  // CHECKSTYLE:OFF
  public void setDate_month(int date_month) {
    // CHECKSTYLE:ON
    this.date_month = date_month;
  }

  /**
   * @return date_day
   */
  public int getDate_day() {
    return date_day;
  }

  /**
   * @param date_day sets date_day
   */
  // CHECKSTYLE:OFF
  public void setDate_day(int date_day) {
    // CHECKSTYLE:ON
    this.date_day = date_day;
  }

  /**
   * @return date_weekday
   */
  public int getDate_weekday() {
    return date_weekday;
  }

  /**
   * @param date_weekday sets date_weekday
   */
  // CHECKSTYLE:OFF
  public void setDate_weekday(int date_weekday) {
    // CHECKSTYLE:ON
    this.date_weekday = date_weekday;
  }

  /**
   * @return fixedPrice
   */
  public Double getFixedPrice() {
    return fixedPrice;
  }

  /**
   * @param fixedPrice sets fixedPrice
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
   * @param dayBeforeDiff sets dayBeforeDiff
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
   * @param dayBeforeRatio sets dayBeforeRatio
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
   * @param dayBeforePrice sets dayBeforePrice
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
   * @param openPrice sets openPrice
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
   * @param highPrice sets highPrice
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
   * @param lowPrice sets lowPrice
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
   * @param volume sets volume
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
   * @param tradingValue sets tradingValue
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
   * @param marketCapt sets marketCapt
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
   * @param widthLowLmt sets widthLowLmt
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
   * @param widthHighLmt sets widthHighLmt
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
   * @param issuedShares sets issuedShares
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
   * @param dividendYield sets dividendYield
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
   * @param perShareDividend sets perShareDividend
   */
  public void setPerShareDividend(Double perShareDividend) {
    this.perShareDividend = perShareDividend;
  }

  /**
   * @return pER
   */
  public Double getpER() {
    return pER;
  }

  /**
   * @param pER sets pER
   */
  // CHECKSTYLE:OFF
  public void setpER(Double pER) {
    // CHECKSTYLE:ON
    this.pER = pER;
  }

  /**
   * @return pBR
   */
  public Double getpBR() {
    return pBR;
  }

  /**
   * @param pBR sets pBR
   */
  // CHECKSTYLE:OFF
  public void setpBR(Double pBR) {
    // CHECKSTYLE:ON
    this.pBR = pBR;
  }

  /**
   * @return ePS
   */
  public Double getePS() {
    return ePS;
  }

  /**
   * @param ePS sets ePS
   */
  // CHECKSTYLE:OFF
  public void setePS(Double ePS) {
    // CHECKSTYLE:ON
    this.ePS = ePS;
  }

  /**
   * @return bPS
   */
  public Double getbPS() {
    return bPS;
  }

  /**
   * @param bPS sets bPS
   */
  // CHECKSTYLE:OFF
  public void setbPS(Double bPS) {
    // CHECKSTYLE:ON
    this.bPS = bPS;
  }

  /**
   * @return minPrchAmnt
   */
  public Double getMinPrchAmnt() {
    return minPrchAmnt;
  }

  /**
   * @param minPrchAmnt sets minPrchAmnt
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
   * @param shareUnit sets shareUnit
   */
  public void setShareUnit(Double shareUnit) {
    this.shareUnit = shareUnit;
  }

  /**
   * @return highDate_diff
   */
  public int getHighDate_diff() {
    return highDate_diff;
  }

  /**
   * @param highDate_diff sets highDate_diff
   */
  // CHECKSTYLE:OFF
  public void setHighDate_diff(int highDate_diff) {
    // CHECKSTYLE:ON
    this.highDate_diff = highDate_diff;
  }

  /**
   * @return highDate_year
   */
  public int getHighDate_year() {
    return highDate_year;
  }

  /**
   * @param highDate_year sets highDate_year
   */
  // CHECKSTYLE:OFF
  public void setHighDate_year(int highDate_year) {
    // CHECKSTYLE:ON
    this.highDate_year = highDate_year;
  }

  /**
   * @return highDate_month
   */
  public int getHighDate_month() {
    return highDate_month;
  }

  /**
   * @param highDate_month sets highDate_month
   */
  // CHECKSTYLE:OFF
  public void setHighDate_month(int highDate_month) {
    // CHECKSTYLE:ON
    this.highDate_month = highDate_month;
  }

  /**
   * @return highDate_day
   */
  public int getHighDate_day() {
    return highDate_day;
  }

  /**
   * @param highDate_day sets highDate_day
   */
  // CHECKSTYLE:OFF
  public void setHighDate_day(int highDate_day) {
    // CHECKSTYLE:ON
    this.highDate_day = highDate_day;
  }

  /**
   * @return highDate_weekday
   */
  public int getHighDate_weekday() {
    return highDate_weekday;
  }

  /**
   * @param highDate_weekday sets highDate_weekday
   */
  // CHECKSTYLE:OFF
  public void setHighDate_weekday(int highDate_weekday) {
    // CHECKSTYLE:ON
    this.highDate_weekday = highDate_weekday;
  }

  /**
   * @return highPriceYear
   */
  public Double getHighPriceYear() {
    return highPriceYear;
  }

  /**
   * @param highPriceYear sets highPriceYear
   */
  public void setHighPriceYear(Double highPriceYear) {
    this.highPriceYear = highPriceYear;
  }

  /**
   * @return lowDate_diff
   */
  public int getLowDate_diff() {
    return lowDate_diff;
  }

  /**
   * @param lowDate_diff sets lowDate_diff
   */
  // CHECKSTYLE:OFF
  public void setLowDate_diff(int lowDate_diff) {
    // CHECKSTYLE:ON
    this.lowDate_diff = lowDate_diff;
  }

  /**
   * @return lowDate_year
   */
  public int getLowDate_year() {
    return lowDate_year;
  }

  /**
   * @param lowDate_year sets lowDate_year
   */
  // CHECKSTYLE:OFF
  public void setLowDate_year(int lowDate_year) {
    // CHECKSTYLE:ON
    this.lowDate_year = lowDate_year;
  }

  /**
   * @return lowDate_month
   */
  public int getLowDate_month() {
    return lowDate_month;
  }

  /**
   * @param lowDate_month sets lowDate_month
   */
  // CHECKSTYLE:OFF
  public void setLowDate_month(int lowDate_month) {
    // CHECKSTYLE:ON
    this.lowDate_month = lowDate_month;
  }

  /**
   * @return lowDate_day
   */
  public int getLowDate_day() {
    return lowDate_day;
  }

  /**
   * @param lowDate_day sets lowDate_day
   */
  // CHECKSTYLE:OFF
  public void setLowDate_day(int lowDate_day) {
    // CHECKSTYLE:ON
    this.lowDate_day = lowDate_day;
  }

  /**
   * @return lowDate_weekday
   */
  public int getLowDate_weekday() {
    return lowDate_weekday;
  }

  /**
   * @param lowDate_weekday sets lowDate_weekday
   */
  // CHECKSTYLE:OFF
  public void setLowDate_weekday(int lowDate_weekday) {
    // CHECKSTYLE:ON
    this.lowDate_weekday = lowDate_weekday;
  }

  /**
   * @return lowPriceYear
   */
  public Double getLowPriceYear() {
    return lowPriceYear;
  }

  /**
   * @param lowPriceYear sets lowPriceYear
   */
  public void setLowPriceYear(Double lowPriceYear) {
    this.lowPriceYear = lowPriceYear;
  }

  /**
   * @return predictDay
   */
  public int getPredictDay() {
    return predictDay;
  }

  /**
   * @param predictDay sets predictDay
   */
  public void setPredictDay(int predictDay) {
    this.predictDay = predictDay;
  }

  /*
   * (非 Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "StockInfoPredict [id=" + id + ", sc=" + sc + ", savedDate=" + savedDate + ", date_year="
        + date_year + ", date_month=" + date_month + ", date_day=" + date_day + ", date_weekday="
        + date_weekday + ", fixedPrice=" + fixedPrice + ", dayBeforeDiff=" + dayBeforeDiff
        + ", dayBeforeRatio=" + dayBeforeRatio + ", dayBeforePrice=" + dayBeforePrice
        + ", openPrice=" + openPrice + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice
        + ", volume=" + volume + ", tradingValue=" + tradingValue + ", marketCapt=" + marketCapt
        + ", widthLowLmt=" + widthLowLmt + ", widthHighLmt=" + widthHighLmt + ", issuedShares="
        + issuedShares + ", dividendYield=" + dividendYield + ", perShareDividend="
        + perShareDividend + ", pER=" + pER + ", pBR=" + pBR + ", ePS=" + ePS + ", bPS=" + bPS
        + ", minPrchAmnt=" + minPrchAmnt + ", shareUnit=" + shareUnit + ", highDate_diff="
        + highDate_diff + ", highDate_year=" + highDate_year + ", highDate_month=" + highDate_month
        + ", highDate_day=" + highDate_day + ", highDate_weekday=" + highDate_weekday
        + ", highPriceYear=" + highPriceYear + ", lowDate_diff=" + lowDate_diff + ", lowDate_year="
        + lowDate_year + ", lowDate_month=" + lowDate_month + ", lowDate_day=" + lowDate_day
        + ", lowDate_weekday=" + lowDate_weekday + ", lowPriceYear=" + lowPriceYear
        + ", predictDay=" + predictDay + "]";
  }


}
