package com.xym.spring.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * desc
 *
 * @author xym
 */
public class TestBeforeAdvice {
    public static void main(String[] args) {

        WaiterI waiterI = new Waiter();
        GreetingBeforeAdvice advice = new GreetingBeforeAdvice();
        //spring代理工厂
        ProxyFactory factory = new ProxyFactory();
        //设置代理目标
        factory.setTarget(waiterI);
        //指定对接口进行代理（使用jdk代理）
        //factory.setInterfaces(waiterI.getClass().getInterfaces());
        //启用优化（使用cglib进行代理）
        factory.setOptimize(true);
        //为代理目标添加增强(由该调用方法可以发现可以设置多个切面，还可以指定执行顺序)
        factory.addAdvice(0, advice);
        //生成代理实例
        WaiterI waiterProxy = (WaiterI) factory.getProxy();
        System.out.println("waiterProxy=" + waiterProxy.getClass().getName());
        waiterProxy.greetTo("xym");
        waiterProxy.serveTo("xym");

    }
}