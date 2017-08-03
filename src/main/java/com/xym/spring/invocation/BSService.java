package com.xym.spring.invocation;

/**
 * desc
 *
 * @author xym
 */
public class BSService implements BSServiceI {


    @Override
    public void method1() {
        System.out.println("执行方法1");
    }

    @Override
    public void method2() {
        System.out.println("执行方法2");
    }
}