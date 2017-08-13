package com.xym.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * desc
 *
 * @author xym
 */
@Aspect
public class PreGreetingAspectJ {


    //定义切点及增强类型
    @Before("execution(* greetTo(..))")
    public void beforeGreeting() {
        System.out.println("How are you2!");
    }

}