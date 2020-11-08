package com.wangerfan.sleep;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName SleepCpuDemo.java
 * @Description sleep避免cpu空转
 * @createTime 2020年11月08日 18:29:00
 */

@Slf4j(topic = "c.SleepCpuDemo")
public class SleepCpuDemo {
    public static void main(String[] args) {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
