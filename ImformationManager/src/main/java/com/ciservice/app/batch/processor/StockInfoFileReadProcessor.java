package com.ciservice.app.batch.processor;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.dto.StockPriceDTO;
import com.ciservice.app.common.exception.SystemErrorException;
import com.ciservice.app.common.file.common.CSVFileReader;
import com.ciservice.app.common.map.MapData;

@Component("stockInfoFileReadProcessor")
public class StockInfoFileReadProcessor implements ItemProcessor<StockPriceDTO, StockInfo> {

  protected static Logger logger = Logger.getLogger(StockInfoFileReadProcessor.class);

  @Value("${common.path.stockdatapath}")
  private String dataPath;

  @Value("${common.path.stockdataext}")
  private String dataExt;

  @Autowired
  @Qualifier("stockDataCSVReader")
  private CSVFileReader<StockDataDTO> stockDataCSVReader;

  @Autowired
  @Qualifier("mapStockInfo")
  private MapData<StockPriceDTO, StockDataDTO, StockInfo> mapStockInfo;

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
   */
  @Override
  public StockInfo process(final StockPriceDTO item) throws Exception {

    final String savedDate = item.getSavedDate();

    final String filePath = getFailePath(dataPath, savedDate, dataExt);

    final List<StockDataDTO> stockDataDTOs = stockDataCSVReader.read(filePath);


    StockInfo stockInfo = null;
    for (final StockDataDTO stockDataDTO : stockDataDTOs) {

      if (item.getSc().equals(stockDataDTO.getSc())) {

        stockInfo = mapStockInfo.map(item, stockDataDTO);

      }

    }

    // Priceに対応するDataファイルなし
    if (stockInfo == null) {
      throw new SystemErrorException("Priceに対応するDataファイルなし");
    }

    return stockInfo;
  }

  /**
   * @param path
   * @param fileFmt
   * @param targetDate
   * @param extention
   * @return maken file path by String
   */
  private String getFailePath(final String path, final String targetDate, final String extention) {

    final StringBuilder fileName = new StringBuilder(path);
    fileName.append(targetDate);
    fileName.append(".");
    fileName.append(extention);

    return fileName.toString();

  }
}


