package com.xym.spring.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * aop及tx命名空间式事务支持
 *
 * @author xym
 */
public class TestMain3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testTransactionAopTx命名空间.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        try {
            userService.addUser();
        } catch (IOException e) {
            e.printStackTrace();
        }

        userService.updateUser();
    }
}