package com.xym.spring.jdktimer;

import java.util.Date;
import java.util.TimerTask;

/**
 * desc
 *
 * @author xym
 */
public class SimpleTimerTask extends TimerTask {
    private int count = 0;

    @Override
    public void run() {
        System.out.println("execute task .");
        //获取本次安排执行的时间点
        Date date = new Date(scheduledExecutionTime());
        System.out.println("本次任务安排执行时间点为：" + date);
        if (++count > 10) {
            //任务运行10次后主动退出执行
            cancel();
        }
    }
}