package com.xym.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * 自定义容器事件
 *
 * @author xym
 */
public class SendMailEvent extends ApplicationContextEvent {

    //邮件发送目的地
    private String to;

    public SendMailEvent(ApplicationContext source, String to) {
        super(source);
        this.to = to;
    }


    public String getTo() {
        return to;
    }

}