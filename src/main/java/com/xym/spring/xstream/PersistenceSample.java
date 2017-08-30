package com.xym.spring.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.xym.spring.domain.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * desc
 *
 * @author xym
 */
public class PersistenceSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserId(1);
        user.setUsername("xstream");
        user.setLastIp("192.168.2.1");
        user.setPassword("123456");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUsername("xstream2");
        user2.setLastIp("192.168.2.100");
        user2.setPassword("111111");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        XStream xStream = new XStream(new DomDriver());
        FilePersistenceStrategy filePersistenceStrategy = new FilePersistenceStrategy(new File("C:\\Users\\xym\\workspace\\mySpring\\out\\"));
        XmlArrayList xmlArrayList = new XmlArrayList(filePersistenceStrategy);
        xmlArrayList.addAll(users);
        xStream.toXML(xmlArrayList);
    }
}