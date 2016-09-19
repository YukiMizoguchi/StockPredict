package com.ciservice.app.batch.processor;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.dto.StockInfoSetDTO;
import com.ciservice.app.common.dto.StockPriceDTO;
import com.ciservice.app.common.map.MapData;

@Component("stockInfoProcessor")
public class StockInfoProcessor implements ItemProcessor<StockInfoSetDTO, Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(StockInfoProcessor.class);

  @Autowired
  @Qualifier("mapStockInfoSet")
  private MapData<Set<StockPriceDTO>, Set<StockDataDTO>, Set<StockInfo>> mapStockInfoSet;

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
   */
  @Override
  public Set<StockInfo> process(StockInfoSetDTO item) throws Exception {

    final Set<StockPriceDTO> stockPriceDTOs = item.getStockPriceSet();
    final Set<StockDataDTO> stockDataDTOs = item.getStockDataSet();

    return mapStockInfoSet.map(stockPriceDTOs, stockDataDTOs);
  }

}
