package com.ciservice.app.common.db.mongodb.repos;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;

/**
 * @author YukiMizoguchi
 *
 */
@Repository
public interface StockInfoRepository extends MongoRepository<StockInfo, Long> {


  StockInfo findOneByScAndSavedDate(String sc, String savedDate);


  // stockInfoUpdate系
  Page<StockInfo> findByRsltDayNullAndRsltDayChkDateNullAndFixedPriceNotNull(Pageable pageable);

  Page<StockInfo> findByRsltWeekNullAndRsltWeekChkDateNullAndFixedPriceNotNull(Pageable pageable);

  Page<StockInfo> findByRsltMonthNullAndRsltMonthChkDateNullAndFixedPriceNotNull(Pageable pageable);

  // CHECKSTYLE:OFF
  Page<StockInfo> findByRsltDayNullAndRsltDayChkDateNullAndRsltWeekNullAndRsltWeekChkDateNullAndRsltMonthNullAndRsltMonthChkDateNullAndFixedPriceNotNull(
      Pageable pageable);
  // CHECKSTYLE:ON

  // stockInfoReUpdate系
  Page<StockInfo> findByRsltDayChkDateBefore(Pageable pageable, Date rsltDayChkDate);

  Page<StockInfo> findByRsltWeekChkDateBefore(Pageable pageable, Date rsltWeekChkDate);

  Page<StockInfo> findByRsltMonthChkDateBefore(Pageable pageable, Date rsltMonthChkDate);

  Page<StockInfo> findByRsltDayChkDateBeforeAndRsltWeekChkDateBeforeAndRsltMonthChkDateBefore(
      Pageable pageable, Date rsltDayChkDate, Date rsltWeekChkDate, Date rsltMonthChkDate);

  // CountSet系
  /*
   * Page<StockInfo> findByLearnCountDayNull(Pageable pageable);
   *
   * Page<StockInfo> findByLearnCountWeekNull(Pageable pageable);
   *
   * Page<StockInfo> findByLearnCountMonthNull(Pageable pageable);
   *
   * Page<StockInfo> findByLearnCountDayNullAndLearnCountWeekNullAndLearnCountMonthNull( Pageable
   * pageable);
   */


  // アーカイブ済み

  // StockInfo findOneByRsltDayNullAndRsltDayChkDateNullAndFixedPriceNotNull();

  // StockInfo findOneByRsltDayChkDateBefore(Date rsltDayChkDate);


}
