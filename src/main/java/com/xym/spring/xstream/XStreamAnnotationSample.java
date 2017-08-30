package com.xym.spring.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xym.spring.domain.LoginLog;
import com.xym.spring.domain.User;

import java.io.*;
import java.util.Date;

/**
 * desc
 *
 * @author xym
 */
public class XStreamAnnotationSample {

    private static User getUser() {
        LoginLog log1 = new LoginLog();
        log1.setIp("192.168.2.1");
        log1.setLoginDate(new Date());

        LoginLog log2 = new LoginLog();
        log2.setIp("192.168.2.100");
        log2.setLoginDate(new Date());

        User user = new User();
        user.setUsername("xstream");
        user.setUserId(1);
        user.addLogs(log1);
        user.addLogs(log2);

        return user;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        XStream xStream = new XStream(new DomDriver());
        //注册带有转换注解的类
        xStream.processAnnotations(User.class);
        xStream.processAnnotations(LoginLog.class);
        User user = getUser();
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("C:\\Users\\xym\\workspace\\mySpring\\out\\XStreamAnnotationSample.xml"), "UTF-8");

        xStream.toXML(user, writer);
    }

}