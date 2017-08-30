package com.xym.spring.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xym.spring.domain.LoginLog;
import com.xym.spring.domain.User;

import java.io.*;
import java.util.Date;

/**
 * 使用操作流的方式处理xml
 *
 * @author xym
 */
public class ObjectStreamSample {

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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        objectToXml();
    }

    //反序列化
    private static void xmlToObject() throws IOException, ClassNotFoundException {
        FileReader fileReader = new FileReader("C:\\Users\\xym\\workspace\\mySpring\\out\\ObjectStreamSample.xml");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        XStream xStream = new XStream(new DomDriver());
        //创建对象输入流
        ObjectInputStream objectInputStream = xStream.createObjectInputStream(bufferedReader);
        //从xml文件中读取对象
        User readObject = (User) objectInputStream.readObject();
        System.out.println(readObject.getUsername() + "--" + readObject.getLogs().size());
    }

    //序列化
    private static void objectToXml() throws IOException {
        XStream xStream = new XStream(new DomDriver());
        User user = getUser();
        //创建输出对象
        PrintWriter pw = new PrintWriter("C:\\Users\\xym\\workspace\\mySpring\\out\\ObjectStreamSample.xml");
        //PrettyPrintWriter writer = new PrettyPrintWriter(pw);
        CompactWriter compactWriter = new CompactWriter(pw);
        //创建对象输出流
        ObjectOutputStream objectOutputStream = xStream.createObjectOutputStream(compactWriter);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
    }
}