package com.ciservice.app.common.db.mongodb.repos;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ciservice.app.common.db.mongodb.doc.ModelInfo;

/**
 * @author YukiMizoguchi
 *
 */
@Repository
public interface ModelInfoRepository extends MongoRepository<ModelInfo, Long> {

}
