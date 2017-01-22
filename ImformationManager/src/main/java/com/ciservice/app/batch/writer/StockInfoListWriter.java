package com.ciservice.app.batch.writer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.constant.SGConst;
import com.ciservice.app.common.db.mongodb.doc.ModelInfo;
import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.db.mongodb.repos.StockInfoRepository;
import com.ciservice.app.common.exception.SystemErrorException;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("stockInfoListWriter")
public class StockInfoListWriter implements ItemWriter<Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(StockInfoListWriter.class);

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
   */
  @Override
  public void write(List<? extends Set<StockInfo>> items) throws Exception {

    /************************************************************
     * StockInfo格納
     ************************************************************/
    // DB使用定義
    ApplicationContext ctxStockInfoReg =
        new GenericXmlApplicationContext(SGConst.PROPERTIES_MONGPDB_BEAN_XML);
    StockInfoRepository stockInfoRepos = ctxStockInfoReg.getBean(StockInfoRepository.class);

    // DB使用定義
    final ApplicationContext ctxModelInfoReg =
        new GenericXmlApplicationContext(SGConst.PROPERTIES_MONGPDB_BEAN_XML);

    final MongoOperations mongoOperation =
        (MongoOperations) ctxModelInfoReg.getBean("mongoTemplate");


    final Set<ModelInfo> modelInfoSet = new HashSet<ModelInfo>();

    try {
      /************************************************************
       * インプットデータ分繰り返し
       ************************************************************/
      for (final Set<StockInfo> stockInfos : items) {

        // StockInfo分更新
        for (final StockInfo stockInfo : stockInfos) {
          // DB更新
          final StockInfo savedStockInfo = stockInfoRepos.save(stockInfo);
          final StringBuilder resultString = new StringBuilder();

          if (savedStockInfo == null) {
            resultString.append("[更新なし]");

          } else {

            if (savedStockInfo.getRsltDay() != null || savedStockInfo.getRsltWeek() != null
                || savedStockInfo.getRsltMonth() != null) {

              boolean contFlg = true;

              for (final ModelInfo modelInfo : modelInfoSet) {
                if (modelInfo.getSavedDate().equals(savedStockInfo.getSavedDate())) {

                  if (savedStockInfo.getRsltDay() != null) {
                    modelInfo.setLearnAvlDay(true);
                  }

                  if (savedStockInfo.getRsltWeek() != null) {
                    modelInfo.setLearnAvlWeek(true);
                  }

                  if (savedStockInfo.getRsltMonth() != null) {
                    modelInfo.setLearnAvlMonth(true);
                  }

                  contFlg = false;

                }
              }

              if (contFlg) {
                final ModelInfo modelInfoAdd = new ModelInfo();

                modelInfoAdd.setSavedDate(savedStockInfo.getSavedDate());

                if (savedStockInfo.getRsltDay() != null) {
                  modelInfoAdd.setLearnAvlDay(true);
                }

                if (savedStockInfo.getRsltWeek() != null) {
                  modelInfoAdd.setLearnAvlWeek(true);
                }

                if (savedStockInfo.getRsltMonth() != null) {
                  modelInfoAdd.setLearnAvlMonth(true);
                }

                modelInfoSet.add(modelInfoAdd);

              }

            }
            resultString.append("[正常更新]");

          }



          resultString.append(" sc=");
          resultString.append(stockInfo.getSc());
          resultString.append(" savedDate=");
          resultString.append(stockInfo.getSavedDate());

          // System.out.println(resultString.toString());
          logger.info(resultString.toString());

        }


      }

      for (final ModelInfo modelInfo : modelInfoSet) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("savedDate").is(modelInfo.getSavedDate()));

        final Update update = new Update();

        if (modelInfo.isLearnAvlDay()) {
          update.set("learnAvlDay", true);
        }

        if (modelInfo.isLearnAvlWeek()) {
          update.set("learnAvlWeek", true);
        }

        if (modelInfo.isLearnAvlMonth()) {
          update.set("learnAvlMonth", true);
        }

        final ModelInfo savedModelInfo = mongoOperation.findAndModify(query, update,
            new FindAndModifyOptions().returnNew(true), ModelInfo.class);
        final StringBuilder resultModelString = new StringBuilder();
        resultModelString.append("[正常更新]");
        resultModelString.append(" savedDate=");
        resultModelString.append(savedModelInfo.getSavedDate());

        logger.info(resultModelString.toString());

      }


    } catch (

    Exception exception) {
      throw new SystemErrorException("IM4102:DBエラー発生（更新）", exception);
    } finally {
      ((ConfigurableApplicationContext) ctxStockInfoReg).close();
      ((ConfigurableApplicationContext) ctxModelInfoReg).close();
    }

  }


}
