package com.xym.spring.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 引介增强
 *
 * @author xym
 */
public class GreetingIntroductionInceptor extends DelegatingIntroductionInterceptor implements GreetingAble {

    private ThreadLocal<Boolean> greetingActiveState = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object result = null;
        if (greetingActiveState.get()) {
            System.out.println("欢迎光临");
            result = super.invoke(mi);
            System.out.println("欢迎下次光临");
        } else {
            result = super.invoke(mi);
        }
        return result;
    }

    @Override
    public void greetingActive(boolean active) {
        greetingActiveState.set(active);
    }
}