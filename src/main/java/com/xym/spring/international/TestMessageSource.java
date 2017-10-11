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
public class TestMessageSource {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("testMessageSource.xml");

        MessageSource messageSource = (MessageSource) context.getBean("myResource");
        //通过第二个动态参数，我们无需使用messageformat进行格式化
        String message = messageSource.getMessage("greeting.common", new Object[]{new GregorianCalendar().getTime()}, Locale.CHINA);
        String message1 = messageSource.getMessage("greeting.common", new Object[]{new GregorianCalendar().getTime()}, Locale.US);
        System.out.println("cn=" + message);
        System.out.println("us=" + message1);
    }
}