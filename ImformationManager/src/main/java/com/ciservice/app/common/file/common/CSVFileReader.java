package com.ciservice.app.common.file.common;

import java.util.List;

/**
 * @author YukiMizoguchi
 *
 */
public interface CSVFileReader<T> {

  public List<T> read(String fileName);

}
