package com.ciservice.app.common.communication.blogic;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ciservice.app.common.communication.common.HTTPClient;
import com.ciservice.app.common.communication.common.RestClient;
import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.exception.SystemErrorException;
import com.ciservice.app.common.json.map.MapStockData;
import com.ciservice.app.common.json.pojo.StockData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author YukiMizoguchi
 *
 */
@Service("stockDataClient")
public class StockDataClientImp implements HTTPClient<StockDataDTO> {

  protected static Logger logger = Logger.getLogger(StockDataClientImp.class);

  @Value("${common.url.stockdata}")
  private String uri;

  private ResponseEntity<String> responceEntity;

  private Set<StockDataDTO> stockPriceDataSet = new HashSet<StockDataDTO>();

  @Autowired
  @Qualifier("restClient")
  private RestClient restClient;

  @Autowired
  @Qualifier("mapStockData")
  private MapStockData mapStockData;

  /*
   * (非 Javadoc)
   *
   * @see com.ciservice.app.common.communication.HTTPClient#getData()
   */
  @Override
  public Set<StockDataDTO> getData() {

    final HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");

    final HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);

    this.setResponceEntity(restClient.get(uri, requestEntity));

    final ObjectMapper mapper = new ObjectMapper();

    try {
      final StockData stockPriceSet =
          mapper.readValue(responceEntity.getBody(), new TypeReference<StockData>() {});

      this.stockPriceDataSet = mapStockData.mapping(stockPriceSet);

    } catch (JsonParseException jsonParseException) {
      throw new SystemErrorException("IM4001:外部通信エラー発生（ボディ形式不正）", jsonParseException);
    } catch (JsonMappingException jsonMappingException) {
      throw new SystemErrorException("IM4001:外部通信エラー発生（ボディ形式不正）", jsonMappingException);
    } catch (IOException ioException) {
      throw new SystemErrorException("IM4001:外部通信エラー発生（ボディ形式不正）", ioException);
    }

    return this.stockPriceDataSet;

  }

  /*
   * (非 Javadoc)
   *
   * @see com.ciservice.app.common.communication.HTTPClient#getResponceEntity()
   */
  @Override
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
