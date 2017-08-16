package com.xym.spring.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * spring默认会回滚运行期异常，提交检查性异常
 * 我们可以通过配置（+、-）改变其行为
 * （-号）回滚仅仅针对检查性异常起作用
 * <p>
 * <p>
 * 重中之重
 *
 * @author xym
 */
public class TestMain2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testTransaction.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceProxy");
        try {
            userService.addUser();
        } catch (IOException e) {
            e.printStackTrace();
        }

        userService.updateUser();
    }

}