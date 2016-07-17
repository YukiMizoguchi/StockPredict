package com.ciservice.app.common.db.mongodb.repos;


import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;

/**
 * @author YukiMizoguchi
 *
 */
@Repository
public interface StockInfoRepository extends MongoRepository<StockInfo, Long> {

  StockInfo findOneByRsltDayNullAndRsltDayChkDateNullAndFixedPriceNotNull();

  StockInfo findOneByRsltDayChkDateBefore(Date rsltDayChkDate);

  StockInfo findOneByScAndSavedDate(String sc, String savedDate);

}
