package com.xym.spring.invocation.cglib;

import com.xym.spring.invocation.BSService;

/**
 * 通过创建子类的方式
 * 缺点：无法对final修饰的方法进行代理,final无法Override
 *
 * @author xym
 */
public class TestMain {
    public static void main(String[] args) {
        //通过cglib实现动态代理，且越过无接口的限制,功能更强大
        CGLibProxy cgLibProxy = new CGLibProxy();

        BSService bsService = (BSService) cgLibProxy.getProxy(BSService.class);

        bsService.method1();
        bsService.method2();
    }

}