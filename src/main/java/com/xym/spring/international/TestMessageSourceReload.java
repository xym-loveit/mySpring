package com.xym.spring.international;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * desc
 *
 * @author xym
 */
public class TestMessageSourceReload {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("testMessageSource.xml");
        MessageSource messageSource = (MessageSource) context.getBean("myReloadResource");

        for (int i = 0; i < 2; i++) {
            String message = messageSource.getMessage("greeting.common", new Object[]{new GregorianCalendar().getTime()}, Locale.CHINA);
            System.out.println(i + "----" + message);
            Thread.currentThread().sleep(20000);
        }

    }
}