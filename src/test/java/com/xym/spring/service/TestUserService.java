package com.xym.spring.service;

import com.xym.spring.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser() {
        boolean matchUser1 = userService.hasMatchUser("admin", "123456");
        boolean matchUser2 = userService.hasMatchUser("admin", "123");
        Assert.assertTrue(matchUser1);
        Assert.assertTrue(!matchUser2);
    }


    @Test
    public void findUserByUserName() {
        User admin = userService.findUserByUserName("admin");
        Assert.assertEquals(admin.getUsername(), "admin");
    }

    @Test
    public void loginSuccess(){
        User admin = userService.findUserByUserName("admin");
        admin.setLastIp("127.0.0.1");
        admin.setLastVisit(new Date());
        userService.loginSuccess(admin);
    }

}
