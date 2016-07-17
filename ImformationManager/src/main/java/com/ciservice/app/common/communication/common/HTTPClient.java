package com.ciservice.app.common.communication.common;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface HTTPClient<E> {

  List<E> getData();


  ResponseEntity<String> getResponceEntity();

}
