package com.xym.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc
 *
 * @author xym
 */
public class TestProxyFactoryBean {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
        WaiterI waiterI =
                (WaiterI) context.getBean("waiter");
        System.out.println("proxy=" + waiterI);
        waiterI.greetTo("xym");
        waiterI.serveTo("xym");
    }
}