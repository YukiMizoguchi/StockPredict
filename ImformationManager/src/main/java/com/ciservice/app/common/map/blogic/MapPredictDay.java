package com.ciservice.app.common.map.blogic;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.json.pojo.PredictedStockInfo;
import com.ciservice.app.common.map.common.MapUtil;

@Component("mapPredictDay")
public class MapPredictDay
    implements MapData<Set<StockInfo>, Set<PredictedStockInfo>, Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(MapPredictDay.class);

  private final MapUtil mapUtil = new MapUtil();

  /**
   * @see com.ciservice.app.common.map.blogic.MapData#map(java.lang.Object, java.lang.Object)
   * @param stockinfos
   * @param result
   * @return Set of StockInfo
   */
  public Set<StockInfo> map(final Set<StockInfo> stockInfos,
      final Set<PredictedStockInfo> resultSet) {

    final Set<StockInfo> stockInfoSet = new HashSet<StockInfo>();

    for (StockInfo stockInfo : stockInfos) {

      stockInfo.setPredictDay(mapUtil.getPredict(stockInfo, resultSet));

      stockInfoSet.add(stockInfo);

    }

    return stockInfoSet;
  }
}
