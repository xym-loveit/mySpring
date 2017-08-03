package com.xym.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 时间发送者
 *
 * @author xym
 */
public class MailSender implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void sendMail(String to) {
        System.out.println("模拟发送邮件~~~~~~~~~~~~~");
        SendMailEvent sendMailEvent = new SendMailEvent(applicationContext, to);

        applicationContext.publishEvent(sendMailEvent);
    }
}