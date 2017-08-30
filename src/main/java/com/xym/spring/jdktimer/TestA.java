package com.xym.spring.jdktimer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * desc
 *
 * @author xym
 */
public class TestA {

    public void AAA() {
        System.out.println(new Date());
    }

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testMethodTimerTask.xml");
        //applicationContext.start();
        //ScheduledExecutorTask scheduledExecutorTask = (ScheduledExecutorTask) applicationContext.getBean("executorTask");

        Thread.sleep(60 * 1000);
    }

}