package com.wangerfan.sleep;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName SleepDemo.java
 * @Description TODO
 * @createTime 2020年11月08日 04:56:00
 */

@Slf4j(topic = "c.SleepDemo")
public class SleepDemo {
    public static void main(String[] args) {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        log.debug("t1线程的state:{}",thread.getState());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t1线程的state:{}",thread.getState());
    }
}
