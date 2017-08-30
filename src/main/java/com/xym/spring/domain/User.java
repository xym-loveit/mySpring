package com.xym.spring.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.xym.spring.xstream.DateConvert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
@XStreamAlias(value = "User")
public class User implements Serializable {

    @XStreamAlias("id")
    private int userId;

    private String username;
    private String password;
    private int credits;
    private String lastIp;

    @XStreamConverter(DateConvert.class)
    private Date lastVisit;

    @XStreamImplicit//隐式集合
    private List<LoginLog> logs = new ArrayList<LoginLog>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public void addLogs(LoginLog loginLog) {
        this.logs.add(loginLog);
    }

    public List<LoginLog> getLogs() {
        return logs;
    }

    public void setLogs(List<LoginLog> logs) {
        this.logs = logs;
    }
}
