package com.ciservice.app.common.communication.common;

import java.util.Set;

import org.springframework.http.ResponseEntity;

public interface HTTPClient<E> {

  Set<E> getData();

  ResponseEntity<String> getResponceEntity();

}
