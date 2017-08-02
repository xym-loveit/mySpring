package com.xym.spring.beanf;

import com.google.common.base.Joiner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 工厂级别后处理器，仅执行一次
 *
 * @author xym
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition user = beanFactory.getBeanDefinition("user");
        System.out.println(Joiner.on(",").join(beanFactory.getBeanDefinitionNames()));


        user.getPropertyValues().addPropertyValue("username", "xym222");
        System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory");
    }
}