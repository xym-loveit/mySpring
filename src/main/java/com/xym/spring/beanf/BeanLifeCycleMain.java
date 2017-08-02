package com.xym.spring.beanf;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * desc
 *
 * @author xym
 */
public class BeanLifeCycleMain {

    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("testBean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(classPathResource);

        //硬编码注册2个后处理器
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new TestPostProcesser());

        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new TestPostProcesserAdapter());

        TestBeanLifeCycle beanLife = (TestBeanLifeCycle) beanFactory.getBean("axx");
        System.out.println(beanLife.getName());

        TestBeanLifeCycle beanLife2 = (TestBeanLifeCycle) beanFactory.getBean("axx");
        System.out.println(beanLife==beanLife2);

        ((ConfigurableBeanFactory) beanFactory).destroySingletons();
    }


}