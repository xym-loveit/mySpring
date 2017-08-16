package com.xym.spring.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 注解式事务支持
 *
 * @author xym
 */
public class TestMain4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testTransactionAnno.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        try {
            userService.addUser();
        } catch (IOException e) {
            e.printStackTrace();
        }

        userService.updateUser();
    }
}