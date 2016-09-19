package com.ciservice.app.common.map;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.enumeration.PredictResult;
import com.ciservice.app.common.exception.BusinessLogicException;
import com.ciservice.app.common.json.pojo.PredictedStockInfo;

@Component("mapPredict")
public class MapPredict
    implements MapData<Set<StockInfo>, Set<PredictedStockInfo>, Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(MapPredict.class);

  /**
   * @see com.ciservice.app.common.map.MapData#map(java.lang.Object, java.lang.Object)
   * @param stockinfos
   * @param result
   * @return Set of StockInfo
   */
  public Set<StockInfo> map(final Set<StockInfo> stockInfos,
      final Set<PredictedStockInfo> resultSet) {

    final Set<StockInfo> stockInfoSet = new HashSet<StockInfo>();

    for (StockInfo stockInfo : stockInfos) {

      stockInfo.setPredictDay(getPredictDay(stockInfo, resultSet));

      stockInfoSet.add(stockInfo);

    }

    return stockInfoSet;
  }

  /**
   * @param sets
   * @param stockInfo
   * @return
   */
  private PredictResult getPredictDay(final StockInfo stockInfo,
      final Set<PredictedStockInfo> sets) {

    final PredictedStockInfo result =
        sets.stream().filter(x -> x.getSc().equals(stockInfo.getSc())).findFirst().orElse(null);

    if (result == null) {
      // 対象のscが見つからなかった場合
      throw new BusinessLogicException("IM8999:内部矛盾発生（データ不整合）");
    }

    // savedDateの突合せ確認
    if (!result.getSavedDate().toString().equals(stockInfo.getSavedDate())) {
      throw new BusinessLogicException("IM8999:内部矛盾発生（データの突合せ処理）");
    }

    return result.getPredictRslt();
  }
}
