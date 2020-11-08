package com.wangerfan.n1;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName ThreadDemo.java
 * @Description TODO
 * @createTime 2020年11月08日 02:55:00
 */

@Slf4j(topic = "c.ThreadDemo")
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                log.debug("running");
            }
        };
        thread.start();
    }
}
