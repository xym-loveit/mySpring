package com.xym.spring.beanf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * desc
 *
 * @author xym
 */
public class TestPostProcesser implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("axx".equals(beanName)) {
            TestBeanLifeCycle beanLife = (TestBeanLifeCycle) bean;
            System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization");
            if (beanLife.getName() == null) {
                beanLife.setName("default name");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("axx")) {
            System.out.println("调用BeanPostProcessor.postProcessAfterInitialization");
            TestBeanLifeCycle beanLife = (TestBeanLifeCycle) bean;
            if (beanLife.getName().equals("name")) {
                beanLife.setName("name_001");
            }
        }
        return bean;
    }
}