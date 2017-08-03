package com.xym.spring.invocation.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * desc
 *
 * @author xym
 */
public class CGLibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);  //设置需要创建的子类
        enhancer.setCallback(this);
        return enhancer.create();//通过字节码技术动态创建子类实例
    }

    //拦截父类所有调用
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("调用目标方法前" + obj.getClass().getName() + "." + method.getName());
        Object result = proxy.invokeSuper(obj, args);//通过代理类调用父类中的方法
        System.out.println("调用目标方法后" + obj.getClass().getName() + "." + method.getName());
        return result;
    }
}