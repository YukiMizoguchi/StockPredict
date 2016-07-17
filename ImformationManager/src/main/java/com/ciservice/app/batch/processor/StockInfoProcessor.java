package com.ciservice.app.batch.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.dto.StockInfoSetDTO;
import com.ciservice.app.common.dto.StockPriceDTO;
import com.ciservice.app.common.exception.BusinessLogicException;
import com.ciservice.app.common.map.MapData;

@Component("stockInfoProcessor")
public class StockInfoProcessor implements ItemProcessor<StockInfoSetDTO, List<StockInfo>> {

  protected static Logger logger = Logger.getLogger(StockInfoProcessor.class);

  @Autowired
  @Qualifier("mapStockInfo")
  private MapData<StockPriceDTO, StockDataDTO, StockInfo> mapStockInfo;

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
   */
  @Override
  public List<StockInfo> process(StockInfoSetDTO item) throws Exception {

    final List<StockPriceDTO> stockPriceDTOs = item.getStockPriceList();
    final List<StockDataDTO> stockDataDTOs = item.getStockDataList();

    // ソート
    Collections.sort(stockPriceDTOs, new Comparator<StockPriceDTO>() {
      public int compare(StockPriceDTO stockPriceDTO1, StockPriceDTO stockPriceDTO2) {
        return stockPriceDTO1.getSc().compareTo((stockPriceDTO2.getSc()));
      }
    });

    Collections.sort(stockDataDTOs, new Comparator<StockDataDTO>() {
      public int compare(StockDataDTO stockDataTO1, StockDataDTO stockDataDTO2) {
        return stockDataTO1.getSc().compareTo((stockDataDTO2.getSc()));
      }
    });

    List<StockInfo> stockInfos = new ArrayList<StockInfo>();

    int icount = 0;
    for (final StockPriceDTO stockPriceDTO : item.getStockPriceList()) {

      final StockDataDTO stockDataDTO = item.getStockDataList().get(icount);
      if (!stockPriceDTO.getSc().equals(stockDataDTO.getSc())) {
        throw new BusinessLogicException("IM4001:通信結果不正（SCデータ不正）");
      }

      final StockInfo stockInfo = mapStockInfo.map(stockPriceDTO, stockDataDTO);

      stockInfos.add(stockInfo);

      icount++;

    }

    return stockInfos;
  }

}
