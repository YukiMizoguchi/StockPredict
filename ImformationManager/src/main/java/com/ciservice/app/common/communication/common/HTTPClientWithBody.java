package com.ciservice.app.common.communication.common;

import java.util.Set;

import org.springframework.http.ResponseEntity;

public interface HTTPClientWithBody<E1, E2> {

  Set<E1> getData(E2 obj);

  ResponseEntity<String> getResponceEntity();

}
