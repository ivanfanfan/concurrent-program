package com.wangerfan.join;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName JoinDemo.java
 * @Description join 同步线程的结果,等待调用线程结束再继续执行别的线程
 *              底层原理就是wait
 * @createTime 2020年11月08日 18:37:00
 */

@Slf4j(topic = "c.JoinDemo")
public class JoinDemo {
    static int r = 0;
    public static void main(String[] args) {

        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r = 10;
            }
        };
        t1.start();
        try {
            t1.join();  //t1.join(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("r的结果{}",r);
    }
}
