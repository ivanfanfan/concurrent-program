package com.wangerfan.interrupt;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName TwoPhaseTermination.java
 * @Description 两阶段终止模式
 * @createTime 2020年11月08日 19:41:00
 */

@Slf4j(topic = "c.TwoPhaseTermination")
public class TwoPhaseTermination {
    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        demo.start();
        Thread.sleep(3500);
        demo.stop();
    }
}
@Slf4j(topic = "c.Demo")
class Demo{
    private Thread monitor;
    //启动监控
    public void start(){
        monitor = new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()) {
                    log.debug("线程被打断,停止运行");
                    break;
                }
                try {
                    currentThread.sleep(1000);
                    log.debug("执行监控操作");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.debug("出异常,重新设置打断标记");
                    currentThread.interrupt(); //这里结合sleep被打断后线程报异常,取消打断标记,所以得重新设置
                }

            }
        }, "t1");
        monitor.start();
    }
    //停止监控
    public void stop(){
        log.debug("打断线程....");
        monitor.interrupt();
    }
}
