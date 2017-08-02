package com.xym.spring.beanf;

import com.xym.spring.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * desc
 *
 * @author xym
 */
public class TestBean {

    public static void main(String[] args) {

        Resource resource = new ClassPathResource("testBean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        System.out.println("init beanf");

        User user = (User) beanFactory.getBean("user");
        System.out.println(user.getUsername() + "--" + user.getPassword());
    }

}