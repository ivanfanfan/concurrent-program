package com.wangerfan.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName InterruptorPark.java
 * @Description park 进行打断标记, interrupted打断后会清楚打断标记
 * @createTime 2020年11月08日 20:10:00
 */

@Slf4j(topic = "c.InterruptPark")
public class InterruptPark {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("执行park..");
            LockSupport.park();
            log.debug("unpark....");
            log.debug("打断状态:{}", Thread.interrupted());

            LockSupport.park();
            log.debug("这里执行不了....");
        }, "t1");

        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
