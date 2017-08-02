package com.xym.spring.beanf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * bean级处理器，处理某个需要特殊控制的bean
 *
 * @author xym
 */
public class TestBeanLifeCycle implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private BeanFactory beanFactory;
    private String beanName;

    public TestBeanLifeCycle() {
        System.out.println("构造函数执行");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("设置属性方法" + name);
        this.name = name;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("设置beanFactory");
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String name) {
        System.out.println("设置BeanName " + name);
        this.beanName = name;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet");
    }

    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy");
    }

    public void myinit() {
        System.out.println("通过调用init-method所指向的myinit方法，修改name");
        this.name = "myinit";
    }

    public void myDestroy() {
        System.out.println("通过调用destroy-method所指向的myDestroy方法");
    }
}