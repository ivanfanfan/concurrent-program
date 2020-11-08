package com.wangerfan.sleep;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName TimeUnitDemo.java
 * @Description TimeUnit类中的sleep方法,可读性高
 * @createTime 2020年11月08日 17:19:00
 */


/**
 * 内部调用的也是Thread.sleep
 * public void sleep(long timeout) throws InterruptedException {
 *         if (timeout > 0) {
 *             long ms = toMillis(timeout);
 *             int ns = excessNanos(timeout, ms);
 *             Thread.sleep(ms, ns);
 *         }
 *     }
 */
@Slf4j(topic = "c.TimeUnitDemo")
public class TimeUnitDemo {
    public static void main(String[] args) throws InterruptedException {
        log.debug("进入sleep");
        TimeUnit.SECONDS.sleep(1);
        log.debug("结束sleep");
    }
}
