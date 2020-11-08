package com.wangerfan.Demo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName OverallPlan.java
 * @Description 统筹规划    简易版
 * @createTime 2020年11月08日 21:23:00
 */

@Slf4j(topic = "c.OverallPlan")
public class OverallPlan {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("老王洗水壶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("老王烧开水");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("老王烧好开水了");
        }, "老王");

        Thread t2 = new Thread(() -> {
            log.debug("小康洗茶壶");
            log.debug("小康洗茶叶");
            log.debug("小康洗茶杯");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("小康泡茶");
        }, "小康");
        t1.start();
        t2.start();
    }
}
