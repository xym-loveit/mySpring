package com.xym.spring.aop.aspectj;

import com.xym.spring.aop.Waiter;
import com.xym.spring.aop.WaiterI;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xym
 */
public class TestAspectJProxyFactory {
    public static void main(String[] args) {

        //基于配置文件中的aop命名空间切面驱动器实施增强-最简洁
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testJZq.xml");
        WaiterI target = (WaiterI) applicationContext.getBean("target");

        target.greetTo("zq");

    }

    /**
     * 采用配置文件应该增强
     */
    private static void proxy1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testJ.xml");

        WaiterI target = (WaiterI) applicationContext.getBean("target");

        target.greetTo("zs");
    }


    /**
     * 采用硬编码应用增强/采用AspectJProxyFactory为目标类生成代理对象
     */
    private static void proxy() {
        WaiterI waiterI = new Waiter();

        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
        aspectJProxyFactory.setTarget(waiterI);
        aspectJProxyFactory.setOptimize(true);//采用cglib动态代理
        aspectJProxyFactory.addAspect(PreGreetingAspectJ.class);

        WaiterI proxy = (WaiterI) aspectJProxyFactory.getProxy();
        proxy.greetTo("admin");
    }
}