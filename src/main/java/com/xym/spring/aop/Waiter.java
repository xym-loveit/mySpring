package com.xym.spring.aop;

/**
 * desc
 *
 * @author xym
 */
public class Waiter implements WaiterI {

    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving to " + name);
    }
}