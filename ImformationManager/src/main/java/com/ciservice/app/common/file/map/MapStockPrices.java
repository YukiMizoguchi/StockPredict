package com.ciservice.app.common.file.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.ciservice.app.common.dto.StockPriceDTO;
import com.ciservice.app.common.exception.SystemErrorException;

/**
 * @author YukiMizoguchi
 *
 */
@Component("mapStockPriceCSV")
public class MapStockPrices implements FieldSetMapper<StockPriceDTO> {

  protected static Logger logger = Logger.getLogger(MapStockPrices.class);

  /*
   * (非 Javadoc)
   *
   * @see
   * org.springframework.batch.item.file.mapping.FieldSetMapper#mapFieldSet(org.springframework.
   * batch.item.file.transform.FieldSet)
   */
  @Override
  public StockPriceDTO mapFieldSet(FieldSet fieldSet) throws BindException {

    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    final SimpleDateFormat sdfSaved = new SimpleDateFormat("yyyyMMdd");

    final StockPriceDTO stockPriceDTO = new StockPriceDTO();
    stockPriceDTO.setSc(fieldSet.readString("sc"));
    stockPriceDTO.setName(fieldSet.readString("name"));
    stockPriceDTO.setBusiness(fieldSet.readString("business"));
    stockPriceDTO.setMarcket(fieldSet.readString("marcket"));

    if (!fieldSet.readString("date").equals("-")) {

      // Date型変換
      try {
        final Date formatedDate = sdf.parse(fieldSet.readString("date"));
        stockPriceDTO.setSavedDate(sdfSaved.format(formatedDate));
        stockPriceDTO.setDate(formatedDate);
      } catch (ParseException exception) {
        throw new SystemErrorException("IM8901:内部アプリケーションエラー（日付変換不正）", exception);
      }
    } else {
      // 取得できなかった場合はメッセージを出力
      throw new SystemErrorException("IM8905:内部アプリケーションエラー（ファイルフォーマット不正（日付取得不可））");
    }

    if (!fieldSet.readString("fixedPrice").equals("-")) {
      stockPriceDTO.setFixedPrice(new Double(fieldSet.readString("fixedPrice")).doubleValue());
    }

    if (!fieldSet.readString("dayBeforeDiff").equals("-")) {
      stockPriceDTO
          .setDayBeforeDiff(new Double(fieldSet.readString("dayBeforeDiff")).doubleValue());

    }
    if (!fieldSet.readString("dayBeforeRatio").equals("-")) {
      stockPriceDTO
          .setDayBeforeRatio(new Double(fieldSet.readString("dayBeforeRatio")).doubleValue());
    }

    if (!fieldSet.readString("dayBeforePrice").equals("-")) {
      stockPriceDTO
          .setDayBeforePrice(new Double(fieldSet.readString("dayBeforePrice")).doubleValue());
    }

    if (!fieldSet.readString("openPrice").equals("-")) {
      stockPriceDTO.setOpenPrice(new Double(fieldSet.readString("openPrice")).doubleValue());
    }

    if (!fieldSet.readString("highPrice").equals("-")) {
      stockPriceDTO.setHighPrice(new Double(fieldSet.readString("highPrice")).doubleValue());
    }

    if (!fieldSet.readString("lowPrice").equals("-")) {
      stockPriceDTO.setLowPrice(new Double(fieldSet.readString("lowPrice")).doubleValue());
    }

    if (!fieldSet.readString("volume").equals("-")) {
      stockPriceDTO.setVolume(new Double(fieldSet.readString("volume")).doubleValue());
    }

    if (!fieldSet.readString("tradingValue").equals("-")) {
      stockPriceDTO.setTradingValue(new Double(fieldSet.readString("tradingValue")).doubleValue());
    }

    if (!fieldSet.readString("marketCapt").equals("-")) {
      stockPriceDTO.setMarketCapt(new Double(fieldSet.readString("marketCapt")).doubleValue());
    }

    if (!fieldSet.readString("widthLowLmt").equals("-")) {
      stockPriceDTO.setWidthLowLmt(new Double(fieldSet.readString("widthLowLmt")).doubleValue());
    }

    if (!fieldSet.readString("widthHighLmt").equals("-")) {
      stockPriceDTO.setWidthHighLmt(new Double(fieldSet.readString("widthHighLmt")).doubleValue());
    }



    return stockPriceDTO;
  }

}
