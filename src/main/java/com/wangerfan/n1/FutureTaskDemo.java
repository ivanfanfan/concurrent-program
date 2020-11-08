package com.wangerfan.n1;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Target;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wangerfan
 * @version 1.0.0
 * @ClassName FutureTaskDemo.java
 * @Description FutureTask实现线程
 * @createTime 2020年11月08日 03:03:00
 */

@Slf4j(topic = "c.FutureTaskDemo")
public class FutureTaskDemo {

    /**
     * FutureTask
     * 继承关系
     * public class FutureTask<V> implements RunnableFuture<V>
     * public interface RunnableFuture<V> extends Runnable, Future<V> TODO 这是什么情况???????????
     * 构造函数
     * public FutureTask(Callable<V> callable)
     * 从FutureTask中获取数据
     * get();
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                    log.debug("FutureTask......Running");
                    Thread.sleep(1000);
                    return 100;
            }
        });
        Thread t1 = new Thread(futureTask,"t1");
        t1.start();
        log.debug("{}",futureTask.get());
    }
}
