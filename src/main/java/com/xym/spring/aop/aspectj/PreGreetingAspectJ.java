package com.xym.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

/**
 * desc
 *
 * @author xym
 */
@Aspect
public class PreGreetingAspectJ {

    public static void main(String[] args) {
    }
    //定义切点及增强类型
    @Before("execution(* greetTo(..))")
    public void beforeGreeting() {
        System.out.println("How are you2!");
    }

}