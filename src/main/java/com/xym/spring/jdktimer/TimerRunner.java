package com.xym.spring.jdktimer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * desc
 *
 * @author xym
 */
public class TimerRunner {
    public static void main(String[] args) {

        //延迟一秒每五分钟执行一次任务
        Timer timer = new Timer();
        TimerTask simpleTimerTask = new SimpleTimerTask();
        timer.schedule(simpleTimerTask, 1000L, 5000L);

    }
}