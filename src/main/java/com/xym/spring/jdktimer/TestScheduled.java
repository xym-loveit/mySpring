package com.xym.spring.jdktimer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc
 *
 * @author xym
 */
public class TestScheduled {
    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testTimerTask.xml");
        //applicationContext.start();
        //ScheduledExecutorTask scheduledExecutorTask = (ScheduledExecutorTask) applicationContext.getBean("executorTask");

        Thread.sleep(60 * 1000);
    }
}