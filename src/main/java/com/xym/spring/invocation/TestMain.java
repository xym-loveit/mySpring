package com.xym.spring.invocation;

import java.lang.reflect.Proxy;

/**
 * jdk基于接口的动态代理，通过实现接口（实现类的方式）
 *
 * @author xym
 */
public class TestMain {
    public static void main(String[] args) {
        BSServiceI serviceI = new BSService();
        BSServiceInvocationHandler invocationHandler = new BSServiceInvocationHandler(serviceI);

        BSServiceI serviceIProxy = (BSServiceI) Proxy.newProxyInstance(serviceI.getClass().getClassLoader(), serviceI.getClass().getInterfaces(), invocationHandler);

        serviceIProxy.method1();
        serviceIProxy.method2();

    }
}