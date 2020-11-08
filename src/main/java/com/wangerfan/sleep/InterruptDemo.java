package com.wangerfan.sleep;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName InterruptDemo.java
 * @Description Interrupt 在多线程程序中打断的线程不是立马开始运行阶段
 * @createTime 2020年11月08日 17:11:00
 */

@Slf4j(topic = "c.InterruptDemo")
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("t1 sleep");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("wake up.............");
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        log.debug("主线程调用Interrupt方法打断t1线程");
        t1.interrupt();
    }
}
