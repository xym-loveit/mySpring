package com.xym.spring.beanf;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * 容器级处理器,处理多bean共通问题
 *
 * @author xym
 */
public class TestPostProcesserAdapter extends InstantiationAwareBeanPostProcessorAdapter {

    //实例化bean前调用,通过过滤仅仅针对user bean进行特殊处理
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("axx".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.实例化bean之前调用");
        }
        return bean;
    }

    //实例化bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("axx".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.实例化bean后调用");
        }
        return true;
    }

    //设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

        if ("axx".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.设置某个属性时调用");
        }
        return pvs;
    }
}