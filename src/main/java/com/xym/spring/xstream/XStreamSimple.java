package com.xym.spring.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xym.spring.domain.LoginLog;
import com.xym.spring.domain.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * desc
 *
 * @author xym
 */
public class XStreamSimple {
    private static XStream xStream;

    static {
        //创建xstream，并指定xml解析器
        xStream = new XStream(new DomDriver());
    }

    public static void main(String[] args) throws Exception {
        objectToXml();
        //xmlToObject();
    }

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

    public static void objectToXml() throws FileNotFoundException {

        User user = getUser();
        //实例化一个文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\xym\\workspace\\mySpring\\out\\XStreamSample.xml");
        //将user对象转为xml并保存到指定的文件
        xStream.toXML(user, fileOutputStream);

    }

    public static void xmlToObject() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\xym\\workspace\\mySpring\\out\\XStreamSample.xml");
        User user = (User) xStream.fromXML(fileInputStream);
        if (user != null) {
            for (LoginLog log : user.getLogs()) {
                System.out.println(log.getIp());
                System.out.println(log.getLoginDate());
            }
        }
    }
}