package com.xym.spring.refbeanproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 一个bean可以引用另一个bean的属性值，通过#{bean.属性}语法
 *
 * @author xym
 */
public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("refbeanproperty.xml");

        RefTargetBean refTargetBean = (RefTargetBean) context.getBean("refTargetBean");
        System.out.println(refTargetBean);
        TestBean2 testBean2 = (TestBean2) context.getBean("testBean2");
        System.out.println(testBean2);
        TestBean2 testBean22 = (TestBean2) context.getBean("testBean2");
        System.out.println(testBean22);
    }
}