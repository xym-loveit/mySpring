package com.xym.spring.propertyEditor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc
 *
 * @author xym
 */
public class TestMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testPropertyEditor.xml");
        Boss boss = (Boss) applicationContext.getBean("boss");
        System.out.println("car="+boss.getCar());
    }
}