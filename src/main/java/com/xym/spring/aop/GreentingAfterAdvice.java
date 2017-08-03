package com.xym.spring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * desc
 *
 * @author xym
 */
public class GreentingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("returnValue " + returnValue);
        System.out.println("欢迎下次光临");
    }
}