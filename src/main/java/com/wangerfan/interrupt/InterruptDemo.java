package com.wangerfan.interrupt;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName InterruptDemo.java
 * @Description 打断线程  Thread.currentThread().isInterrupted() 获取当前线程的打断标记
 * @createTime 2020年11月08日 19:28:00
 */

@Slf4j(topic = "c.InterruptDemo")
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if(Thread.currentThread().isInterrupted()){
                    log.debug("线程被打断,退出循环");
                    break;
                }
            }
        }, "t1");

        t1.start();
        Thread.sleep(200);
        log.debug("打断t1线程");
        t1.interrupt();

    }
}
