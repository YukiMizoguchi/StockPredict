package com.ciservice.app.common.communication.common;

import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restClient")
public class RestClientImp implements RestClient {

  @SuppressWarnings("unused")
  private static final Logger LOG = Logger.getLogger(RestClientImp.class);

  private final RestTemplate rest;

  /**
   * Constructor
   */
  public RestClientImp() {
    this.rest = new RestTemplate();
    this.rest.getMessageConverters().add(0,
        new StringHttpMessageConverter(Charset.forName("UTF-8")));
  }

  /*
   * (非 Javadoc)
   *
   * @see com.ciservice.app.common.communication.RestClient#get(java.lang.String)
   */
  @Override
  public ResponseEntity<String> get(String uri, HttpEntity<String> requestEntity) {
    ResponseEntity<String> responseEntity =
        rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
    return responseEntity;
  }

  /*
   * (非 Javadoc)
   *
   * @see com.ciservice.app.common.communication.RestClient#post(java.lang.String, java.lang.String)
   */
  @Override
  public ResponseEntity<String> post(String uri, HttpEntity<String> requestEntity) {
    ResponseEntity<String> responseEntity =
        rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
    return responseEntity;
  }
}
