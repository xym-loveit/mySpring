package com.xym.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * desc
 *
 * @author xym
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (args.length > 0) {
            String name = (String) args[0];
            System.out.println("target=" + target.getClass().getName() + "." + method.getName());
            System.out.println("你好 " + name);
        } else {
            System.out.println("target=" + target.getClass().getName() + "." + method.getName());
        }
    }
}