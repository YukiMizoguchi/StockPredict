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

  // StockInfo findOneByRsltDayNullAndRsltDayChkDateNullAndFixedPriceNotNull();

  Page<StockInfo> findByRsltDayNullAndRsltDayChkDateNullAndFixedPriceNotNull(Pageable pageable);

  StockInfo findOneByRsltDayChkDateBefore(Date rsltDayChkDate);

  StockInfo findOneByScAndSavedDate(String sc, String savedDate);

}
