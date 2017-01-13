package com.ciservice.app.batch.writer;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ciservice.app.common.constant.SGConst;
import com.ciservice.app.common.db.mongodb.doc.StockInfo;
import com.ciservice.app.common.db.mongodb.repos.StockInfoRepository;
import com.ciservice.app.common.exception.SystemErrorException;
import com.ciservice.app.common.util.MailService;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("stockInfoListSendWriter")
public class StockInfoListSendWriter implements ItemWriter<Set<StockInfo>> {

  protected static Logger logger = Logger.getLogger(StockInfoListSendWriter.class);

  @Autowired
  private VelocityEngine velocityEngine;

  /*
   * (非 Javadoc)
   *
   * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
   */
  @Override
  public void write(List<? extends Set<StockInfo>> items) throws Exception {

    /************************************************************
     * インプットデータ分繰り返し
     ************************************************************/
    for (final Set<StockInfo> stockInfos : items) {

      /************************************************************
       * StockInfo格納
       ************************************************************/
      // DB使用定義
      ApplicationContext ctxStockInfoReg =
          new GenericXmlApplicationContext(SGConst.PROPERTIES_MONGPDB_BEAN_XML);
      StockInfoRepository stockInfoRepos = ctxStockInfoReg.getBean(StockInfoRepository.class);

      try {

        // StockInfo分更新
        for (final StockInfo stockInfo : stockInfos) {
          // DB更新
          final StockInfo savedStockInfo = stockInfoRepos.save(stockInfo);
          final StringBuilder resultString = new StringBuilder();

          if (savedStockInfo == null) {
            resultString.append("更新なし");

          } else {
            resultString.append("正常更新");

          }

          resultString.append(" sc=");
          resultString.append(stockInfo.getSc());
          resultString.append(" savedDate=");
          resultString.append(stockInfo.getSavedDate());

          System.out.println(resultString.toString());

        }

      } catch (Exception exception) {
        throw new SystemErrorException("IM4102:DBエラー発生（更新）", exception);
      } finally {
        ((ConfigurableApplicationContext) ctxStockInfoReg).close();
      }

      // メール本文の生成
      Map<String, Object> model = new HashMap<String, Object>();
      StringWriter writer = new StringWriter();
      model.put("stockInfos", stockInfos);
      VelocityContext ctx = new VelocityContext(model);
      velocityEngine.mergeTemplate("predict_mail.html", "UTF-8", ctx, writer);


      // メール送信
      MailService mailService = new MailService();
      mailService.setMailFromAdder("test@test.com");
      String[] mailTo = {"mituzero@gmail.com"};
      mailService.setMailToAdder(mailTo);
      mailService.setMessageTextHtml(writer.toString());
      mailService.doSendMail();

    }

  }

}
