package com.ciservice.app.common.db.mongodb.doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author YukiMizoguchi
 *
 */
@Document(collection = "modelinfo")
public class ModelInfo {

  @Id
  private String id;
  private String savedDate;
  private Integer learnCountDay;
  private Integer learnCountWeek;
  private Integer learnCountMonth;
  private boolean learnAvlDay;
  private boolean learnAvlWeek;
  private boolean learnAvlMonth;

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
   * @return learnCountDay
   */
  public Integer getLearnCountDay() {
    return learnCountDay;
  }

  /**
   * @param learnCountDay sets learnCountDay
   */
  public void setLearnCountDay(Integer learnCountDay) {
    this.learnCountDay = learnCountDay;
  }

  /**
   * @return learnCountWeek
   */
  public Integer getLearnCountWeek() {
    return learnCountWeek;
  }

  /**
   * @param learnCountWeek sets learnCountWeek
   */
  public void setLearnCountWeek(Integer learnCountWeek) {
    this.learnCountWeek = learnCountWeek;
  }

  /**
   * @return learnCountMonth
   */
  public Integer getLearnCountMonth() {
    return learnCountMonth;
  }

  /**
   * @param learnCountMonth sets learnCountMonth
   */
  public void setLearnCountMonth(Integer learnCountMonth) {
    this.learnCountMonth = learnCountMonth;
  }

  /**
   * @return learnAvlDay
   */
  public boolean isLearnAvlDay() {
    return learnAvlDay;
  }

  /**
   * @param learnAvlDay sets learnAvlDay
   */
  public void setLearnAvlDay(boolean learnAvlDay) {
    this.learnAvlDay = learnAvlDay;
  }

  /**
   * @return learnAvlWeek
   */
  public boolean isLearnAvlWeek() {
    return learnAvlWeek;
  }

  /**
   * @param learnAvlWeek sets learnAvlWeek
   */
  public void setLearnAvlWeek(boolean learnAvlWeek) {
    this.learnAvlWeek = learnAvlWeek;
  }

  /**
   * @return learnAvlMonth
   */
  public boolean isLearnAvlMonth() {
    return learnAvlMonth;
  }

  /**
   * @param learnAvlMonth sets learnAvlMonth
   */
  public void setLearnAvlMonth(boolean learnAvlMonth) {
    this.learnAvlMonth = learnAvlMonth;
  }

  /**
   * @see java.lang.Object#toString()
   * @return
   */
  @Override
  public String toString() {
    return "ModelInfo [id=" + id + ", savedDate=" + savedDate + ", learnCountDay=" + learnCountDay
        + ", learnCountWeek=" + learnCountWeek + ", learnCountMonth=" + learnCountMonth
        + ", learnAvlDay=" + learnAvlDay + ", learnAvlWeek=" + learnAvlWeek + ", learnAvlMonth="
        + learnAvlMonth + "]";
  }

}
