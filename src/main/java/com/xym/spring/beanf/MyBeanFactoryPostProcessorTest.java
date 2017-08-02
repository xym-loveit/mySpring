package com.xym.spring.beanf;

import com.xym.spring.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc
 *
 * @author xym
 */
public class MyBeanFactoryPostProcessorTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("testBean.xml");

        User user = (User) context.getBean("user");
        System.out.println(user.getUsername());
    }
}