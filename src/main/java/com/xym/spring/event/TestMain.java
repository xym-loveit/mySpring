package com.xym.spring.event;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc
 *
 * @author xym
 */
public class TestMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        MailSender mailSender = (MailSender) applicationContext.getBean("mailSender");
        mailSender.sendMail("xym");

    }
}