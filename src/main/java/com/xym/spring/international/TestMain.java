package com.xym.spring.international;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 本地化对象是实现国际化的基础
 * 语言+国家地区=本地化对象
 *
 * @author xym
 */
public class TestMain {
    public static void main(String[] args) {
/*        //带有语言和国家地区信息的本地化对象
        Locale locale = new Locale("zh", "CN");
        //只有语言信息的本地化对象
        Locale locale2 = new Locale("zh");
        //等同于Locale("zh", "CN")
        Locale china = Locale.CHINA;
        //等同于Locale("zh");
        Locale chinese = Locale.CHINESE;
        //获取本地系统默认的本地化对象
        Locale aDefault = Locale.getDefault();


        //使用本地化方式对货币进行格式化
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        double d = 123456.78d;
        System.out.println(currencyInstance.format(d));

        //使用本地化对象格式化日期
        Locale locale1 = new Locale("en", "US");
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dateInstance.format(new Date()));*/


        //ApplicationContext本身就已经实现了messagesource，自动拥有国际化功能
        ApplicationContext context = new ClassPathXmlApplicationContext("testMessageSource.xml");
        String message = context.getMessage("greeting.common", new Object[]{new GregorianCalendar().getTime()}, Locale.CHINA);
        System.out.println(message);
    }
}