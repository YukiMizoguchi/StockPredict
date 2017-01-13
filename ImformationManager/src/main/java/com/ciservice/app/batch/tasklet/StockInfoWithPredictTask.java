package com.ciservice.app.batch.tasklet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.dto.StockInfoSetDTO;

/**
 * @author YukiMizoguchi
 *
 */
public class StockInfoWithPredictTask implements Tasklet {

  protected static Logger logger = Logger.getLogger(StockInfoWithPredictTask.class);


  @Autowired
  @Qualifier("stockInfoReader")
  private ItemReader<StockInfoSetDTO> readData;

  @Autowired
  @Qualifier("stockInfoProcessor")
  private ItemProcessor<StockInfoSetDTO, Set<StockInfo>> processData;

  @Autowired
  @Qualifier("predictProcessor")
  private ItemProcessor<Set<StockInfo>, Set<StockInfo>> predictData;

  @Autowired
  @Qualifier("stockInfoListSendWriter")
  private ItemWriter<Set<StockInfo>> writeData;

  /*
   * (非 Javadoc)
   *
   * @see
   * org.springframework.batch.core.step.tasklet.Tasklet#execute(org.springframework.batch.core.
   * StepContribution, org.springframework.batch.core.scope.context.ChunkContext)
   */
  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {

    // 情報取得
    final StockInfoSetDTO stockInfoSetDTO = readData.read();

    // 取得情報の加工
    // （情報の結合、変換など）
    final Set<StockInfo> StockInfos = processData.process(stockInfoSetDTO);

    // AI(Tensorflow)による予測
    final Set<StockInfo> preStockInfos = predictData.process(StockInfos);

    // SetからListへ変換
    final List<Set<StockInfo>> stockInfoList = new ArrayList<>();
    stockInfoList.add(preStockInfos);

    // DBへの書き込み
    writeData.write(stockInfoList);

    return RepeatStatus.FINISHED;
  }

}
