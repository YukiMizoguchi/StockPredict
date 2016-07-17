package com.ciservice.app.common.dto;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;

/**
 * @author YukiMizoguchi
 *
 */
public class RESTRequestDTO {

  protected static Logger logger = Logger.getLogger(RESTRequestDTO.class);

  private HttpHeaders headers;
  private String uri;
  private Map<String, String> parameters;

  /**
   * @return headers
   */
  public HttpHeaders getHeaders() {
    return headers;
  }

  /**
   * @param headers セットする headers
   */
  public void setHeaders(HttpHeaders headers) {
    this.headers = headers;
  }

  /**
   * @return uri
   */
  public String getUri() {
    return uri;
  }

  /**
   * @param uri セットする uri
   */
  public void setUri(String uri) {
    this.uri = uri;
  }

  /**
   * @return parameters
   */
  public Map<String, String> getParameters() {
    return parameters;
  }

  /**
   * @param parameters セットする parameters
   */
  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }

  /*
   * (非 Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "RESTRequestDTO [headers=" + headers + ", uri=" + uri + ", parameters=" + parameters
        + "]";
  }


}
