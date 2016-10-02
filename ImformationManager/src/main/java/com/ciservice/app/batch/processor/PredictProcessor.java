package com.ciservice.app.batch.processor;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.communication.common.HTTPClientWithBody;
import com.ciservice.app.common.db.mongodb.doc.StockInfo;

@Component("predictProcessor")
public class PredictProcessor implements ItemProcessor<Set<StockInfo>, Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(PredictProcessor.class);

  @Autowired
  @Qualifier("predictDayClient")
  private HTTPClientWithBody<StockInfo, Set<StockInfo>> clientDay;

  @Autowired
  @Qualifier("predictWeekClient")
  private HTTPClientWithBody<StockInfo, Set<StockInfo>> clientWeek;

  @Autowired
  @Qualifier("predictMonthClient")
  private HTTPClientWithBody<StockInfo, Set<StockInfo>> clientMonth;

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
   */
  @Override
  public Set<StockInfo> process(Set<StockInfo> item) throws Exception {

    // AIによる予測(DAY)
    final Set<StockInfo> sInfosDay = clientDay.getData(item);

    // AIによる予測(WEEK)
    final Set<StockInfo> sInfosDayWeek = clientWeek.getData(sInfosDay);

    // AIによる予測(MONTH)
    final Set<StockInfo> sInfosDayWeekMonth = clientMonth.getData(sInfosDayWeek);

    return sInfosDayWeekMonth;
  }

}
