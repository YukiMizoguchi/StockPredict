package com.ciservice.app.common.communication.common;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface RestClient {

  /**
   * @param uri
   * @param requestEntity
   * @return ResponseEntit
   */
  ResponseEntity<String> get(String uri, HttpEntity<String> requestEntity);

  /**
   * @param uri
   * @param requestEntity
   * @return ResponseEntity
   */
  ResponseEntity<String> post(String uri, HttpEntity<String> requestEntity);


}
