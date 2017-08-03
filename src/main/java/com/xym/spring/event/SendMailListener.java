package com.xym.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * 事件监听器
 *
 * @author xym
 */
public class SendMailListener implements ApplicationListener<SendMailEvent> {

    @Override
    public void onApplicationEvent(SendMailEvent sendMailEvent) {
        System.out.println("SendMailListener :向 " + sendMailEvent.getTo() + " 发送了一份邮件");
    }
}