package com.ciservice.app.common.map.blogic;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.dto.StockPriceDTO;
import com.ciservice.app.common.exception.BusinessLogicException;

/**
 * @author YukiMizoguchi
 *
 */
@Component("mapStockInfoSet")
public class MapStockInfoSet
    implements MapData<Set<StockPriceDTO>, Set<StockDataDTO>, Set<StockInfo>> {

  @Autowired
  @Qualifier("mapStockInfo")
  private MapData<StockPriceDTO, StockDataDTO, StockInfo> mapStockInfo;

  protected static Logger logger = Logger.getLogger(MapStockInfoSet.class);

  /**
   * @see com.ciservice.app.common.map.blogic.MapData#map(java.lang.Object, java.lang.Object)
   * @param stockPriceSet
   * @param stockDataSet
   * @return Set of StockInfo
   */
  public Set<StockInfo> map(final Set<StockPriceDTO> stockPriceSet,
      final Set<StockDataDTO> stockDataSet) {

    final Set<StockInfo> stockInfoSet = new HashSet<StockInfo>();

    for (StockPriceDTO stockPriceDTO : stockPriceSet) {

      final StockDataDTO stockDataDTO = getMachedData(stockPriceDTO, stockDataSet);

      final StockInfo stockInfo = mapStockInfo.map(stockPriceDTO, stockDataDTO);

      stockInfoSet.add(stockInfo);

    }

    return stockInfoSet;
  }

  private StockDataDTO getMachedData(final StockPriceDTO stockPriceDTO,
      final Set<StockDataDTO> stockDataSet) {

    final StockDataDTO stockDataDTO = stockDataSet.stream()
        .filter(x -> x.getSc().equals(stockPriceDTO.getSc())).findFirst().orElse(null);

    if (stockDataDTO == null) {
      // 対象のscが見つからなかった場合
      throw new BusinessLogicException("IM8999:内部矛盾発生（データ不整合）");
      // return null;
    }

    return stockDataDTO;
  }

}
