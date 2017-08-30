package com.xym.spring.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.xym.spring.xstream.DateConvert;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/28.
 */
@XStreamAlias("LoginLog")
public class LoginLog implements Serializable {


    private int loginLogId;

    @XStreamAsAttribute
    @XStreamAlias("LID")
    private int userId;
    private String ip;
    @XStreamConverter(DateConvert.class)
    private Date loginDate;

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
