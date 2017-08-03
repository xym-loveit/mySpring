package com.xym.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 引介增强作用于类上（动态增加方法、实现接口），感觉很强大
 *
 * @author xym
 */
public class TestIntroductionInceptor {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");
        waiter.greetTo("xym");
        waiter.serveTo("xym");

        GreetingAble waiter1 = (GreetingAble) waiter;
        ((GreetingAble) waiter).greetingActive(Boolean.TRUE);

        waiter.greetTo("xym");
        waiter.serveTo("xym");
    }
}