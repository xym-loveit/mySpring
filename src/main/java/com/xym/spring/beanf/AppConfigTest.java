package com.xym.spring.beanf;

import com.xym.spring.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * desc
 *
 * @author xym
 */
public class AppConfigTest {
    public static void main(String[] args) {

        //通过一个带有@Configurable的pojo来实例化bean
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        User user = (User) applicationContext.getBean("user");
        System.out.println(user.getUsername() + "--" + user.getPassword());
    }
}