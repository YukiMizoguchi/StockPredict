package com.ciservice.app.common.communication.blogic;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ciservice.app.common.communication.common.HTTPClientWithBody;
import com.ciservice.app.common.communication.common.RestClient;
import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.exception.SystemErrorException;
import com.ciservice.app.common.json.pojo.PredictedStockInfo;
import com.ciservice.app.common.map.MapData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author YukiMizoguchi
 *
 */
@Service("predictClient")
public class PredictClientImp implements HTTPClientWithBody<StockInfo, Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(PredictClientImp.class);

  @Value("${common.url.predict}")
  private String uri;

  private ResponseEntity<String> responceEntity;

  @Autowired
  @Qualifier("restClient")
  private RestClient restClient;

  @Autowired
  @Qualifier("mapPredict")
  private MapData<Set<StockInfo>, Set<PredictedStockInfo>, Set<StockInfo>> mapPredict;

  /*
   * (非 Javadoc)
   *
   * @see com.ciservice.app.common.communication.common.HTTPClientWithBody#getData(java.lang.Object)
   */
  @Override
  public Set<StockInfo> getData(Set<StockInfo> stockInfos) {

    Set<StockInfo> predictedStockInfos;

    // リクエストヘッダの設定
    final HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");


    // Body部生成
    final ObjectMapper mapperReq = new ObjectMapper();

    String reqBodyJson;
    try {
      reqBodyJson = mapperReq.writeValueAsString(stockInfos);

      final HttpEntity<String> requestEntity = new HttpEntity<String>(reqBodyJson, headers);

      this.setResponceEntity(restClient.post(uri, requestEntity));

    } catch (JsonProcessingException jsonProcessingException) {
      throw new SystemErrorException("IM8999:内部矛盾発生（Json変換失敗）", jsonProcessingException);
    }


    try {

      final List<PredictedStockInfo> result = new ObjectMapper().readValue(responceEntity.getBody(),
          new TypeReference<List<PredictedStockInfo>>() {});

      final Set<PredictedStockInfo> resultSet = new HashSet<PredictedStockInfo>(result);

      predictedStockInfos = mapPredict.map(stockInfos, resultSet);
      // predictedStockInfos = resultSet;

    } catch (JsonParseException jsonParseException) {
      throw new SystemErrorException("IM4001:外部通信エラー発生（ボディ形式不正）", jsonParseException);
    } catch (JsonMappingException jsonMappingException) {
      throw new SystemErrorException("IM4001:外部通信エラー発生（ボディ形式不正）", jsonMappingException);
    } catch (IOException ioException) {
      throw new SystemErrorException("IM4001:外部通信エラー発生（ボディ形式不正）", ioException);
    }

    return predictedStockInfos;

  }

  /*
   * (非 Javadoc)
   *
   * @see com.ciservice.app.common.communication.HTTPClient#getResponceEntity()
   */
  public ResponseEntity<String> getResponceEntity() {
    return responceEntity;
  }

  /**
   * @param responceEntity セットする responceEntity
   */
  private void setResponceEntity(ResponseEntity<String> responceEntity) {
    this.responceEntity = responceEntity;
  }

}
