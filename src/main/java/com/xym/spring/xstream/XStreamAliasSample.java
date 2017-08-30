package com.xym.spring.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xym.spring.domain.LoginLog;
import com.xym.spring.domain.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Locale;

/**
 * desc
 *
 * @author xym
 */
public class XStreamAliasSample {


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


    public static void main(String[] args) throws FileNotFoundException {
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new DateConvert(Locale.CHINA));
        User user = getUser();

        //设置类别名，默认为当前类名加包名
        xStream.alias("LoginLog", LoginLog.class);
        xStream.alias("User", User.class);
        //设置类成员别名
        xStream.aliasField("id", User.class, "userId");
        //将LoginLog的userId属性视为xml属性，默认为xml元素
        xStream.aliasAttribute(LoginLog.class, "userId", "id");
        xStream.useAttributeFor(LoginLog.class, "userId");
        //去掉集合类型生成xml父节点，即去掉<logs>标记
        xStream.addImplicitCollection(User.class, "logs");

        //实例化一个文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\xym\\workspace\\mySpring\\out\\XStreamAliasSample.xml");
        xStream.toXML(user, fileOutputStream);
    }

}