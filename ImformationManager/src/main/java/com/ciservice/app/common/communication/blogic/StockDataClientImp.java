package com.ciservice.app.common.communication.blogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

  private List<StockDataDTO> stockPriceDataList = new ArrayList<StockDataDTO>();

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
  public List<StockDataDTO> getData() {

    final HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");

    final HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);

    this.setResponceEntity(restClient.get(uri, requestEntity));

    final ObjectMapper mapper = new ObjectMapper();

    try {
      final StockData stockPriceList =
          mapper.readValue(responceEntity.getBody(), new TypeReference<StockData>() {});

      this.stockPriceDataList = mapStockData.mapping(stockPriceList);

    } catch (JsonParseException jsonParseException) {
      throw new SystemErrorException("IM4001:外部通信エラー発生（ボディ形式不正）", jsonParseException);
    } catch (JsonMappingException jsonMappingException) {
      throw new SystemErrorException("IM4001:外部通信エラー発生（ボディ形式不正）", jsonMappingException);
    } catch (IOException ioException) {
      throw new SystemErrorException("IM4001:外部通信エラー発生（ボディ形式不正）", ioException);
    }

    return this.stockPriceDataList;

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
