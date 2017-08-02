package com.xym.spring.beanf;

import com.xym.spring.domain.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * desc
 *
 * @author xym
 */
@Configurable
public class AppConfig {


    @Bean(name = "user")
    public User getUser() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("123456");
        return user;
    }
}