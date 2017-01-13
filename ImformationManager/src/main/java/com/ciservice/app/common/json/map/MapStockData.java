package com.ciservice.app.common.json.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.exception.SystemErrorException;
import com.ciservice.app.common.json.pojo.StockData;

@Component("mapStockData")
public class MapStockData {

  protected static Logger logger = Logger.getLogger(MapStockData.class);

  /**
   * @param stockDataSet
   * @return Set of StockDataDTO
   */
  public Set<StockDataDTO> mapping(StockData stockDataSet) {

    final Set<StockDataDTO> stockDataDTOSet = new HashSet<StockDataDTO>();

    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    for (String[] stockData : stockDataSet.aaData) {

      final StockDataDTO stockDataDTO = new StockDataDTO();
      stockDataDTO.setSc(stockData[0]);
      stockDataDTO.setName(stockData[1]);
      stockDataDTO.setMarcket(stockData[2]);
      stockDataDTO.setBusiness(stockData[3]);

      if (!stockData[4].equals("-")) {
        stockDataDTO.setMarketCapt(new Double(stockData[4]).doubleValue());
      }

      if (!stockData[5].equals("-")) {
        stockDataDTO.setIssuedShares(new Double(stockData[5]).doubleValue());
      }

      if (!stockData[6].equals("-")) {
        stockDataDTO.setDividendYield(new Double(stockData[6]).doubleValue());
      }

      if (!stockData[7].equals("-")) {
        stockDataDTO.setPerShareDividend(new Double(stockData[7]).doubleValue());
      }

      if (!stockData[8].equals("-")) {
        stockDataDTO.setPER(new Double(stockData[8]).doubleValue());
      }

      if (!stockData[9].equals("-")) {
        stockDataDTO.setPBR(new Double(stockData[9]).doubleValue());
      }

      if (!stockData[10].equals("-")) {
        stockDataDTO.setEPS(new Double(stockData[10]).doubleValue());
      }

      if (!stockData[11].equals("-")) {
        stockDataDTO.setBPS(new Double(stockData[11]).doubleValue());
      }

      if (!stockData[12].equals("-")) {
        stockDataDTO.setMinPrchAmnt(new Double(stockData[12]).doubleValue());
      }

      if (!stockData[13].equals("-")) {
        stockDataDTO.setShareUnit(new Double(stockData[13]).doubleValue());
      }

      if (!stockData[14].equals("-")) {

        // Date型変換
        try {
          final Date formatedHighDate = sdf.parse(stockData[14]);
          stockDataDTO.setHighDate(formatedHighDate);
        } catch (ParseException parseException) {
          throw new SystemErrorException("IM8901:内部アプリケーションエラー（日付変換不正）", parseException);
        }

      } else {
        stockDataDTO.setHighDate(null);
      }

      if (!stockData[15].equals("-")) {
        stockDataDTO.setHighPriceYear(new Double(stockData[15]).doubleValue());
      }

      if (!stockData[16].equals("-")) {

        // Date型変換
        try {
          final Date formatedLowDate = sdf.parse(stockData[16]);
          stockDataDTO.setLowDate(formatedLowDate);
        } catch (ParseException parseException) {
          throw new SystemErrorException("IM8901:内部アプリケーションエラー（日付変換不正）", parseException);
        }

      } else {
        stockDataDTO.setLowDate(null);
      }

      if (!stockData[17].equals("-")) {
        stockDataDTO.setLowPriceYear(new Double(stockData[17]).doubleValue());
      }

      stockDataDTOSet.add(stockDataDTO);

    }

    return stockDataDTOSet;
  }
}
