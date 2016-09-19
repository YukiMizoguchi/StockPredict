package com.ciservice.app.common.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author YukiMizoguchi
 *
 */
public class DateSerializer extends JsonSerializer<Date> {

  protected static Logger logger = Logger.getLogger(DateSerializer.class);

  @Override
  public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formatted = formatter.format(value);

    jgen.writeString(formatted);

  }
}
