package com.ciservice.app.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ciservice.app.common.exception.SystemErrorException;

/**
 * @author YukiMizoguchi
 *
 */
public class CommonUtil {

  protected static Logger logger = Logger.getLogger(CommonUtil.class);

  /**
   * @param savedDate
   * @return Date
   */
  public Date getSavedDate(String savedDate) {

    final SimpleDateFormat sdfSaved = new SimpleDateFormat("yyyyMMdd");

    final Date formatedDate;
    // Date型変換
    try {
      formatedDate = sdfSaved.parse(savedDate);
    } catch (ParseException exception) {
      throw new SystemErrorException("IM8901:内部アプリケーションエラー（日付変換不正）", exception);
    }

    return formatedDate;

  }

  /**
   * @param savedDate
   * @return String
   */
  public String getSavedDate(Date savedDate) {

    final SimpleDateFormat sdfSaved = new SimpleDateFormat("yyyyMMdd");

    final String formatedDate = sdfSaved.format(savedDate);

    return formatedDate;

  }

}
