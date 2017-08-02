package com.xym.spring.web;

import com.xym.spring.domain.User;
import com.xym.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/28.
 */
@Controller
@RequestMapping(value = "/myAdmin")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "/login";
    }

    //@Autowired
    //private MyDataSource myDataSource;


    @RequestMapping("/index2")
    public String index2() {

        //System.out.println("myDataSource="+myDataSource);
        return "/login";
    }


    @RequestMapping("/login")
    public ModelAndView login(String userName, @RequestParam("passWord") String password, HttpServletRequest request) {
        boolean matchUser = userService.hasMatchUser(userName, password);
        if (matchUser) {
            User user = userService.findUserByUserName(userName);
            user.setLastVisit(new Date());
            user.setLastIp(request.getLocalAddr());
            userService.loginSuccess(user);

            return new ModelAndView("main", "user", user);
        } else {
            return new ModelAndView("login", "error", "用户名或密码有误！");
        }
    }

}
