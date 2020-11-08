package com.wangerfan.interrupt;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName SleepInterruptDemo.java
 * @Description TODO
 * @createTime 2020年11月08日 19:13:00
 */

@Slf4j(topic = "c.SleepInterruptDemo")
public class SleepInterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("sleep......");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        log.debug("打断标记:{}",t1.isInterrupted());
        t1.start();
        log.debug("打断标记:{}",t1.isInterrupted());
        Thread.sleep(2000);
        log.debug("执行interrupt");
        t1.interrupt();
        Thread.sleep(200);
        //如果这里不进行sleep 这里的基本上会同时执行打断和获取状态, 下条代码会在打断之前执行,结果为true 这是可能发生的情况
        log.debug("打断标记:{}",t1.isInterrupted());
    }
}
