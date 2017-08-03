package com.xym.spring.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * desc
 *
 * @author xym
 */
public class BSServiceInvocationHandler implements InvocationHandler {

    private Object target;

    public BSServiceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前" + target.getClass().getName() + "." + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("方法执行后");
        return result;
    }
}