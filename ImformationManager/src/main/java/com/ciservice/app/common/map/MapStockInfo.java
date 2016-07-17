package com.ciservice.app.common.map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.dto.StockPriceDTO;

/**
 * @author YukiMizoguchi
 *
 */
@Component("mapStockInfo")
public class MapStockInfo implements MapData<StockPriceDTO, StockDataDTO, StockInfo> {

  protected static Logger logger = Logger.getLogger(MapStockInfo.class);

  // CHECKSTYLE:OFF
  /*
   * (非 Javadoc)
   *
   * @see com.ciservice.app.common.map.MapData#map(java.lang.Object, java.lang.Object)
   */
  public StockInfo map(StockPriceDTO stockPriceDTO, StockDataDTO stockDataDTO) {
    // CHECKSTYLE:ON

    final StockInfo stockInfo = new StockInfo();

    stockInfo.setSc(stockPriceDTO.getSc());
    stockInfo.setSavedDate(stockPriceDTO.getSavedDate());
    stockInfo.setName(stockPriceDTO.getName());
    stockInfo.setBusiness(stockPriceDTO.getBusiness());
    stockInfo.setMarcket(stockPriceDTO.getMarcket());
    stockInfo.setDate(stockPriceDTO.getDate());
    stockInfo.setFixedPrice(stockPriceDTO.getFixedPrice());
    stockInfo.setDayBeforeDiff(stockPriceDTO.getDayBeforeDiff());
    stockInfo.setDayBeforeRatio(stockPriceDTO.getDayBeforeRatio());
    stockInfo.setDayBeforePrice(stockPriceDTO.getDayBeforePrice());
    stockInfo.setOpenPrice(stockPriceDTO.getOpenPrice());
    stockInfo.setHighPrice(stockPriceDTO.getHighPrice());
    stockInfo.setLowPrice(stockPriceDTO.getLowPrice());
    stockInfo.setVolume(stockPriceDTO.getVolume());
    stockInfo.setTradingValue(stockPriceDTO.getTradingValue());
    stockInfo.setMarketCapt(stockPriceDTO.getMarketCapt());
    stockInfo.setWidthLowLmt(stockPriceDTO.getWidthLowLmt());
    stockInfo.setWidthHighLmt(stockPriceDTO.getWidthHighLmt());
    stockInfo.setIssuedShares(stockDataDTO.getIssuedShares());
    stockInfo.setDividendYield(stockDataDTO.getDividendYield());
    stockInfo.setPerShareDividend(stockDataDTO.getPerShareDividend());
    stockInfo.setPER(stockDataDTO.getPER());
    stockInfo.setPBR(stockDataDTO.getPBR());
    stockInfo.setEPS(stockDataDTO.getEPS());
    stockInfo.setBPS(stockDataDTO.getBPS());
    stockInfo.setMinPrchAmnt(stockDataDTO.getMinPrchAmnt());
    stockInfo.setShareUnit(stockDataDTO.getShareUnit());
    stockInfo.setHighDate(stockDataDTO.getHighDate());
    stockInfo.setHighPriceYear(stockDataDTO.getHighPriceYear());
    stockInfo.setLowDate(stockDataDTO.getLowDate());
    stockInfo.setLowPriceYear(stockDataDTO.getLowPriceYear());

    return stockInfo;

  }

}
