package com.ciservice.app.batch.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.communication.common.HTTPClient;
import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.dto.StockInfoSetDTO;
import com.ciservice.app.common.dto.StockPriceDTO;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("stockInfoReader")
public class StockInfoReader implements ItemReader<StockInfoSetDTO> {

  @Autowired
  @Qualifier("stockPricesClient")
  private HTTPClient<StockPriceDTO> clientPrices;

  @Autowired
  @Qualifier("stockDataClient")
  private HTTPClient<StockDataDTO> clientData;

  /**
   * Reads next record from input
   */
  public StockInfoSetDTO read() throws Exception {

    final StockInfoSetDTO stockInfoSetDTO = new StockInfoSetDTO();

    // 価格取得
    final List<StockPriceDTO> stockPriceList = clientPrices.getData();
    stockInfoSetDTO.setStockPriceList(stockPriceList);

    // 株情報取得
    final List<StockDataDTO> stockDataList = clientData.getData();
    stockInfoSetDTO.setStockDataList(stockDataList);

    return stockInfoSetDTO;

  }

}
