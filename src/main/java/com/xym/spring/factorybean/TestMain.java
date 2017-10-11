package com.xym.spring.factorybean;

import com.xym.spring.propertyEditor.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc
 *
 * @author xym
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/testFactoryBean.xml");
        Car carF1 = (Car) context.getBean("carF1");
        System.out.println("carF1=" + carF1);
        CarFactoryBean factoryBean = (CarFactoryBean) context.getBean("&carF1");
        System.out.println("factoryBean=" + factoryBean);
        System.out.println(factoryBean.getCarInfo() + "--" + factoryBean.getObject().toString() + "--" + factoryBean.isSingleton() + "--" + factoryBean.getObjectType());
    }
}