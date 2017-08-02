package com.xym.spring.service;

import com.xym.spring.dao.LoginLogDao;
import com.xym.spring.dao.UserDao;
import com.xym.spring.domain.LoginLog;
import com.xym.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/28.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String username, String password) {
        int count = userDao.getMatchCount(username, password);
        return count > 0;
    }

    public User findUserByUserName(String username) {
        User user = userDao.findUserByUserName(username);
        return user;
    }


    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLog.setUserId(user.getUserId());

        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
