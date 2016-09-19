package com.ciservice.app.common.file.blogic;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PassThroughFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.exception.SystemErrorException;
import com.ciservice.app.common.file.common.CSVFileReader;

/**
 * @author YukiMizoguchi
 *
 */
@Component("stockDataCSVReader")
public class StockDataCSVReader implements CSVFileReader<StockDataDTO> {


  @Autowired
  @Qualifier("mapStockDataCSV")
  private FieldSetMapper<StockDataDTO> fileMapper;

  @Autowired
  ResourceLoader resourceLoader;

  protected static Logger logger = Logger.getLogger(StockDataCSVReader.class);


  /*
   * (非 Javadoc)
   *
   * @see com.ciservice.app.common.file.blogic.CSVFileReader#read(java.lang.String)
   */
  @Override
  public Set<StockDataDTO> read(final String fileName) {


    // CSVの項目定義
    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
    lineTokenizer.setNames(new String[] {"sc", "name", "business", "marcket", "marketCapt",
        "issuedShares", "dividendYield", "perShareDividend", "pER", "pBR", "ePS", "bPS",
        "minPrchAmnt", "shareUnit", "highDate", "highPriceYear", "lowDate", "lowPriceYear"});
    lineTokenizer.setStrict(true);

    DefaultLineMapper<FieldSet> lineMapper = new DefaultLineMapper<FieldSet>();
    lineMapper.setLineTokenizer(lineTokenizer);
    lineMapper.setFieldSetMapper(new PassThroughFieldSetMapper());

    FlatFileItemReader<FieldSet> reader = new FlatFileItemReader<FieldSet>();
    reader.setLineMapper(lineMapper);

    final Resource resource = resourceLoader.getResource("classpath:" + fileName);
    reader.setResource(resource);
    reader.setLinesToSkip(1);
    reader.setEncoding("windows-31j");
    reader.open(new ExecutionContext());

    final Set<StockDataDTO> stockDataDTOs = new HashSet<StockDataDTO>();

    FieldSet fieldSet = null;

    do {

      try {
        fieldSet = reader.read();
      } catch (Exception exception) {
        throw new SystemErrorException("読み込みファイル不正（StockData）", exception);
      }

      if (fieldSet != null) {
        try {
          final StockDataDTO stockDataDTO = fileMapper.mapFieldSet(fieldSet);
          stockDataDTOs.add(stockDataDTO);
        } catch (BindException bindException) {
          throw new SystemErrorException("マッピング不正（StockData）", bindException);
        }
      }

    } while (fieldSet != null);

    return stockDataDTOs;

  }

}
