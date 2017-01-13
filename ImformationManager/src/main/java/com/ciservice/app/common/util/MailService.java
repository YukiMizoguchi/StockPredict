package com.ciservice.app.common.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author YukiMizoguchi
 *
 */
@Service
public class MailService {

  protected static Logger logger = Logger.getLogger(MailService.class);

  @Autowired
  private JavaMailSender mailSender;

  private String messageTextPlain;
  private String messageTextHtml;
  private String mailFromAdder;
  private String[] mailToAdder;

  /**
   * @throws MessagingException
   */
  @Async // 非同期
  public void doSendMail() throws MessagingException {

    MimeMessage message = mailSender.createMimeMessage();

    // 添付ファイルを用いる場合は、tureを設定します
    MimeMessageHelper helper = new MimeMessageHelper(message, false);

    if (messageTextPlain == null && messageTextHtml == null) {
      throw new MessagingException();
    }
    // メール本文のセット
    helper.setText(messageTextPlain, messageTextHtml);

    if (this.mailFromAdder == null) {
      throw new MessagingException();
    }
    // 送信元を設定
    helper.setFrom(this.mailFromAdder);


    if (this.mailToAdder == null) {
      throw new MessagingException();
    }
    // 送信先を設定
    helper.setTo(this.mailToAdder);
    // 送信
    mailSender.send(message);
  }

  /**
   * @return mailFromAdder
   */
  public String getMailFromAdder() {
    return mailFromAdder;
  }

  /**
   * @param mailFromAdder sets mailFromAdder
   */
  public void setMailFromAdder(String mailFromAdder) {
    this.mailFromAdder = mailFromAdder;
  }

  /**
   * @return mailToAdder
   */
  public String[] getMailToAdder() {
    return mailToAdder;
  }

  /**
   * @param mailToAdder sets mailToAdder
   */
  public void setMailToAdder(String[] mailToAdder) {
    this.mailToAdder = mailToAdder;
  }

  /**
   * @return messageTextPlain
   */
  public String getMessageTextPlain() {
    return messageTextPlain;
  }

  /**
   * @param messageTextPlain sets messageTextPlain
   */
  public void setMessageTextPlain(String messageTextPlain) {
    this.messageTextPlain = messageTextPlain;
  }

  /**
   * @return messageTextHtml
   */
  public String getMessageTextHtml() {
    return messageTextHtml;
  }

  /**
   * @param messageTexthtml sets messageTextHtml
   */
  public void setMessageTextHtml(String messageTextHtml) {
    this.messageTextHtml = messageTextHtml;
  }
}
