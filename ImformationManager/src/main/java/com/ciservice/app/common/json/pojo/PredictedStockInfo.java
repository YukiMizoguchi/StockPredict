package com.ciservice.app.common.json.pojo;

import com.ciservice.app.common.enumeration.PredictResult;

/**
 * @author YukiMizoguchi
 *
 */
public class PredictedStockInfo {

  private String sc;
  private String savedDate;
  private PredictResult predictRslt;

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
   * @return predictRslt
   */
  public PredictResult getPredictRslt() {
    return predictRslt;
  }

  /**
   * @param predictRslt sets predictRslt
   */
  public void setPredictRslt(PredictResult predictRslt) {
    this.predictRslt = predictRslt;
  }

  /**
   * @see java.lang.Object#toString()
   * @return
   */
  @Override
  public String toString() {
    return "PredictedStockInfo [sc=" + sc + ", savedDate=" + savedDate + ", predictRslt="
        + predictRslt + "]";
  }



}
