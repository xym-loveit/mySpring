package com.xym.spring.propertyplaceholder;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * desc
 *
 * @author xym
 */
public class TestMain {
    public static void main(String[] args) {
        XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
        xmlWebApplicationContext.setConfigLocation("applicationContext.xml");

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyDataSource.class);
        applicationContext.setParent(applicationContext);

        MyDataSource myDataSource = (MyDataSource) applicationContext.getBean("myDataSource");
        System.out.println("myDataSource" + myDataSource);
    }
}