package com.wangerfan.n1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName RunnableDemo.java
 * @Description Runnable实现多线程
 * @createTime 2020年11月08日 02:46:00
 */
@Slf4j(topic = "c.RunnableDemo")
public class RunnableDemo {
    public static void main(String[] args) {
        /**
         * @FunctionalInterface  Runnable
         * Thread 和 Runnable的区别
         *
         *  public void run() {
         *         if (target != null) {
         *             target.run();
         *         }
         *     }
         *
         */

    }
    public static void test1(){
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                log.debug("running");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    public static void test2(){
        Runnable runnable = () -> log.debug("running");
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(() -> log.debug("running"));
        thread.start();
        thread1.start();
    }
}
