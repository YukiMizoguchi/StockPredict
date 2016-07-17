package com.ciservice.app.batch.tasklet;

import java.util.List;

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
public class StockInfoTask implements Tasklet {

  protected static Logger logger = Logger.getLogger(StockInfoTask.class);


  @Autowired
  @Qualifier("stockInfoReader")
  private ItemReader<StockInfoSetDTO> readData;

  @Autowired
  @Qualifier("stockInfoProcessor")
  private ItemProcessor<StockInfoSetDTO, List<StockInfo>> processData;

  @Autowired
  @Qualifier("stockInfoWriter")
  private ItemWriter<StockInfo> writeData;

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

    final StockInfoSetDTO stockInfoSetDTO = readData.read();


    final List<StockInfo> StockInfos = processData.process(stockInfoSetDTO);

    writeData.write(StockInfos);

    return RepeatStatus.FINISHED;
  }

}
