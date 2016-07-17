package com.ciservice.app.common.file.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

/**
 * @author YukiMizoguchi
 *
 */
public class StepListener implements StepExecutionListener, ApplicationContextAware {

  protected static Logger logger = Logger.getLogger(StepListener.class);
  private Resource[] resources;
  private ApplicationContext applicationContext;
  private String filePattern;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  public void setFilePattern(String filePattern) {
    this.filePattern = filePattern;
  }

  @Override
  public void beforeStep(StepExecution stepExecution) {

    @SuppressWarnings("unchecked")
    MultiResourceItemReader<FieldSet> reader =
        (MultiResourceItemReader<FieldSet>) applicationContext.getBean("multiResourceReader");
    try {
      resources = applicationContext.getResources(filePattern);
      reader.setResources(resources);
    } catch (IOException ex) {
      logger.info("ファイル読み込みに失敗", ex);
    }
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {

    if (stepExecution.getExitStatus().equals(ExitStatus.COMPLETED)
        && stepExecution.getStatus().equals(BatchStatus.COMPLETED) && resources.length > 0) {

      for (Resource resource : resources) {
        try {
          File oldFile = new File(resource.getFile().getAbsolutePath());
          File newFile = new File(resource.getFile().getAbsolutePath() + ".processed");
          FileUtils.copyFile(oldFile, newFile);
          oldFile.delete();
        } catch (IOException ex) {
          logger.info("ファイル削除に失敗", ex);
        }
      }
    }

    return stepExecution.getExitStatus();
  }

}
