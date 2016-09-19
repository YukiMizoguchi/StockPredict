package com.ciservice.app.common.json.util;

import java.io.IOException;
import java.security.InvalidParameterException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author YukiMizoguchi
 *
 */
public class JsonConverter {

  protected static Logger logger = Logger.getLogger(JsonConverter.class);

  private static ObjectMapper mapper = new ObjectMapper();

  private JsonConverter() {
    // do nothing.
  }

  /**
   * @param object
   * @return
   * @throws JsonGenerationException
   * @throws JsonMappingException
   * @throws IOException
   */
  public static String toString(final Object object)
      throws JsonGenerationException, JsonMappingException, IOException {

    String json = mapper.writeValueAsString(object);

    return json;
  }

  /**
   * @param jsonString
   * @param clazz
   * @return
   * @throws JsonParseException
   * @throws JsonMappingException
   * @throws IOException
   */
  public static <T> T toObject(final String jsonString, final Class<T> clazz)
      throws JsonParseException, JsonMappingException, IOException {

    T object = null;

    if (jsonString == null) {
      throw new InvalidParameterException("jsonString is null.");
    }
    object = mapper.readValue(jsonString, clazz);

    return object;
  }

  /**
   * @param jsonString
   * @param valueTypeRef
   * @return
   * @throws JsonParseException
   * @throws JsonMappingException
   * @throws IOException
   */
  public static <T> T toObject(String jsonString, TypeReference<T> valueTypeRef)
      throws JsonParseException, JsonMappingException, IOException {

    T object = null;

    if (jsonString == null) {
      throw new InvalidParameterException("jsonString is null.");
    }
    object = mapper.readValue(jsonString, valueTypeRef);

    return object;
  }
}
