package com.ciservice.app.common.map.common;

import java.util.Set;

import org.apache.log4j.Logger;

import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.enumeration.PredictResult;
import com.ciservice.app.common.exception.BusinessLogicException;
import com.ciservice.app.common.json.pojo.PredictedStockInfo;

/**
 * @author YukiMizoguchi
 *
 */
public class MapUtil {

  protected static Logger logger = Logger.getLogger(MapUtil.class);

  /**
   * @param sets
   * @param stockInfo
   * @return
   */
  public PredictResult getPredict(final StockInfo stockInfo, final Set<PredictedStockInfo> sets) {

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
