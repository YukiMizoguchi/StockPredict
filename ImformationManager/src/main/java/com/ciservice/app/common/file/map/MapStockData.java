package com.ciservice.app.common.file.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.ciservice.app.common.dto.StockDataDTO;
import com.ciservice.app.common.exception.SystemErrorException;

/**
 * @author YukiMizoguchi
 *
 */
@Component("mapStockDataCSV")
public class MapStockData implements FieldSetMapper<StockDataDTO> {

  protected static Logger logger = Logger.getLogger(MapStockData.class);

  /*
   * (非 Javadoc)
   *
   * @see
   * org.springframework.batch.item.file.mapping.FieldSetMapper#mapFieldSet(org.springframework.
   * batch.item.file.transform.FieldSet)
   */
  @Override
  public StockDataDTO mapFieldSet(FieldSet fieldSet) throws BindException {

    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    final StockDataDTO stockDataDTO = new StockDataDTO();
    stockDataDTO.setSc(fieldSet.readString("sc"));
    stockDataDTO.setName(fieldSet.readString("name"));
    stockDataDTO.setBusiness(fieldSet.readString("business"));
    stockDataDTO.setMarcket(fieldSet.readString("marcket"));

    if (!fieldSet.readString("marketCapt").equals("-")) {
      stockDataDTO.setMarketCapt(new Double(fieldSet.readString("marketCapt")).doubleValue());
    }

    if (!fieldSet.readString("issuedShares").equals("-")) {
      stockDataDTO.setIssuedShares(new Double(fieldSet.readString("issuedShares")).doubleValue());
    }

    if (!fieldSet.readString("dividendYield").equals("-")) {
      stockDataDTO.setDividendYield(new Double(fieldSet.readString("dividendYield")).doubleValue());
    }

    if (!fieldSet.readString("perShareDividend").equals("-")) {
      stockDataDTO
          .setPerShareDividend(new Double(fieldSet.readString("perShareDividend")).doubleValue());
    }

    if (!fieldSet.readString("pER").equals("-")) {
      stockDataDTO.setPER(new Double(fieldSet.readString("pER")).doubleValue());
    }

    if (!fieldSet.readString("pBR").equals("-")) {
      stockDataDTO.setPBR(new Double(fieldSet.readString("pBR")).doubleValue());
    }

    if (!fieldSet.readString("ePS").equals("-")) {
      stockDataDTO.setEPS(new Double(fieldSet.readString("ePS")).doubleValue());
    }

    if (!fieldSet.readString("bPS").equals("-")) {
      stockDataDTO.setBPS(new Double(fieldSet.readString("bPS")).doubleValue());
    }

    if (!fieldSet.readString("minPrchAmnt").equals("-")) {
      stockDataDTO.setMinPrchAmnt(new Double(fieldSet.readString("minPrchAmnt")).doubleValue());
    }

    if (!fieldSet.readString("shareUnit").equals("-")) {
      stockDataDTO.setShareUnit(new Double(fieldSet.readString("shareUnit")).doubleValue());
    }

    if (!fieldSet.readString("highDate").equals("-")) {

      // Date型変換
      try {
        final Date formatedHighDate = sdf.parse(fieldSet.readString("highDate"));
        stockDataDTO.setHighDate(formatedHighDate);
      } catch (ParseException parseException) {
        throw new SystemErrorException("IM8901:内部アプリケーションエラー（日付変換不正）", parseException);
      }

    } else {
      stockDataDTO.setHighDate(null);
    }

    if (!fieldSet.readString("highPriceYear").equals("-")) {
      stockDataDTO.setHighPriceYear(new Double(fieldSet.readString("highPriceYear")).doubleValue());
    }

    if (!fieldSet.readString("lowDate").equals("-")) {

      // Date型変換
      try {
        final Date formatedLowDate = sdf.parse(fieldSet.readString("lowDate"));
        stockDataDTO.setLowDate(formatedLowDate);
      } catch (ParseException parseException) {
        throw new SystemErrorException("IM8901:内部アプリケーションエラー（日付変換不正）", parseException);
      }

    } else {
      stockDataDTO.setLowDate(null);
    }

    if (!fieldSet.readString("lowPriceYear").equals("-")) {
      stockDataDTO.setLowPriceYear(new Double(fieldSet.readString("lowPriceYear")).doubleValue());
    }

    return stockDataDTO;
  }

}
