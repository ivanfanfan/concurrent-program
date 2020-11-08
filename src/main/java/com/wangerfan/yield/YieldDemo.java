package com.wangerfan.yield;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName YieldDemo.java
 * @Description yield让线程从Running状态进入Runnable状态,然后调度别的线程
 *              sleep会进入Timed Waiting状态 阻塞
 *
 *              public static native void yield();
 * @createTime 2020年11月08日 17:23:00
 */

/**
 * yield和线程setPriority优先级调度
 * 优先级默认调度是5 最大10 最小1
 */
@Slf4j(topic = "c.YieldDemo")
public class YieldDemo {
    public static void main(String[] args) {
        Runnable task1 = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                for(;;){
                    System.out.println("----->1   " + count++);
                }
            }
        };

        Runnable task2 = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                for(;;){
//                    Thread.yield();
                    System.out.println("                  ---->2    " + count++);
                }
            }
        };

        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
//
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

    }
}
