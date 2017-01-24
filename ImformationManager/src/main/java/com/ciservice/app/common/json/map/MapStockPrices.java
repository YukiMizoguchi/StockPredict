package com.ciservice.app.common.json.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.dto.StockPriceDTO;
import com.ciservice.app.common.exception.SystemErrorException;
import com.ciservice.app.common.json.pojo.StockPrices;

/**
 * @author YukiMizoguchi
 *
 */
@Component("mapStockPrices")
public class MapStockPrices {

  protected static Logger logger = Logger.getLogger(MapStockPrices.class);

  /**
   * @param stockPriceSet
   * @return Set of StockPriceDTO
   */
  public Set<StockPriceDTO> mapping(StockPrices stockPriceSet) {

    final Set<StockPriceDTO> stockPriceDTOSet = new HashSet<StockPriceDTO>();

    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    final SimpleDateFormat sdfSaved = new SimpleDateFormat("yyyyMMdd");

    for (String[] stockPrice : stockPriceSet.japanAllAtockPrices) {

      final StockPriceDTO stockPriceDTO = new StockPriceDTO();
      stockPriceDTO.setSc(stockPrice[0]);
      stockPriceDTO.setName(stockPrice[1]);
      stockPriceDTO.setMarcket(stockPrice[2]);
      stockPriceDTO.setBusiness(stockPrice[3]);

      if (!stockPrice[4].equals("-")) {

        // 年を付与する（前日の年を取得し付与する）
        Calendar calendar = Calendar.getInstance();
        // 前日の年に変更
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        int year = calendar.get(Calendar.YEAR);
        StringBuffer sb = new StringBuffer();
        sb.append(year + "/" + stockPrice[4]);

        // Date型変換
        try {
          final Date formatedDate = sdf.parse(sb.toString());
          stockPriceDTO.setSavedDate(sdfSaved.format(formatedDate));
          stockPriceDTO.setDate(formatedDate);
        } catch (ParseException exception) {
          throw new SystemErrorException("IM8901:内部アプリケーションエラー（日付変換不正）", exception);
        }
      } else {
        // 取得できなかった場合は取得時間を設定
        final Date toDay = new Date();
        stockPriceDTO.setSavedDate(sdfSaved.format(toDay));
        stockPriceDTO.setDate(toDay);
      }

      if (!stockPrice[5].equals("-")) {
        stockPriceDTO.setFixedPrice(new Double(stockPrice[5]).doubleValue());
      }

      if (!stockPrice[6].equals("-")) {
        stockPriceDTO.setDayBeforeDiff(new Double(stockPrice[6]).doubleValue());

      }
      if (!stockPrice[7].equals("-")) {
        stockPriceDTO.setDayBeforeRatio(new Double(stockPrice[7]).doubleValue());
      }

      if (!stockPrice[8].equals("-")) {
        stockPriceDTO.setDayBeforePrice(new Double(stockPrice[8]).doubleValue());
      }

      if (!stockPrice[9].equals("-")) {
        stockPriceDTO.setOpenPrice(new Double(stockPrice[9]).doubleValue());
      }

      if (!stockPrice[10].equals("-")) {
        stockPriceDTO.setHighPrice(new Double(stockPrice[10]).doubleValue());
      }

      if (!stockPrice[11].equals("-")) {
        stockPriceDTO.setLowPrice(new Double(stockPrice[11]).doubleValue());
      }

      if (!stockPrice[12].equals("-")) {
        stockPriceDTO.setVolume(new Double(stockPrice[12]).doubleValue());
      }

      if (!stockPrice[13].equals("-")) {
        stockPriceDTO.setTradingValue(new Double(stockPrice[13]).doubleValue());
      }

      if (!stockPrice[14].equals("-")) {
        stockPriceDTO.setMarketCapt(new Double(stockPrice[14]).doubleValue());
      }

      if (!stockPrice[15].equals("-")) {
        stockPriceDTO.setWidthLowLmt(new Double(stockPrice[15]).doubleValue());
      }

      if (!stockPrice[16].equals("-")) {
        stockPriceDTO.setWidthHighLmt(new Double(stockPrice[16]).doubleValue());
      }

      stockPriceDTOSet.add(stockPriceDTO);

    }

    return stockPriceDTOSet;
  }
}
