package com.ciservice.app.batch.processor;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;

/**
 * @author YukiMizoguchi
 *
 */
@Component("addRsltProcessor")
public class AddResultProcessor implements ItemProcessor<Set<StockInfo>, Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(AddResultProcessor.class);

  @Autowired
  @Qualifier("addDayRsltProcessor")
  private ItemProcessor<Set<StockInfo>, Set<StockInfo>> processDay;

  @Autowired
  @Qualifier("addWeekRsltProcessor")
  private ItemProcessor<Set<StockInfo>, Set<StockInfo>> processWeek;

  @Autowired
  @Qualifier("addMonthRsltProcessor")
  private ItemProcessor<Set<StockInfo>, Set<StockInfo>> processMonth;

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
   */
  @Override
  public Set<StockInfo> process(Set<StockInfo> item) throws Exception {

    // 日次データ更新
    final Set<StockInfo> sInfosDay = processDay.process(item);
    System.out.println("日次結果設定完了");

    // 週次データ更新
    final Set<StockInfo> sInfosDayWeek = processWeek.process(sInfosDay);
    System.out.println("週次結果設定完了");

    // 月次データ更新
    final Set<StockInfo> sInfosDayWeekMonth = processMonth.process(sInfosDayWeek);
    System.out.println("月次結果設定完了");

    return sInfosDayWeekMonth;
  }

}
