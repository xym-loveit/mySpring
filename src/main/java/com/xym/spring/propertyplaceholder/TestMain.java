package com.xym.spring.propertyplaceholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc
 *
 * @author xym
 */
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
/*
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyDataSource.class);
        applicationContext.setParent(xmlWebApplicationContext);*/

        MyDataSource myDataSource = (MyDataSource) applicationContext.getBean("myDataSource");
        System.out.println("myDataSource" + myDataSource);
    }
}