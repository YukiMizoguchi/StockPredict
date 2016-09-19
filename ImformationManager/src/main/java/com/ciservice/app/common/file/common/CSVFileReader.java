package com.ciservice.app.common.file.common;

import java.util.Set;

/**
 * @author YukiMizoguchi
 *
 */
public interface CSVFileReader<T> {

  public Set<T> read(String fileName);

}
