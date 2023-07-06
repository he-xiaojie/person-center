package com.hexiaojie.person.center.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    /**
     * 创建线程的7种方式。总体来说分为2类
     * 1。通过ThreadPoolExecutor 创建的线程池
     * 2。由Executors 创建的线程池
     */

    /**
     * 1. 创建一个固定大小的线程池，可控制并发的线程数。超出的线程会在队列中等待
     */
    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);

    /**
     * 2. 创建⼀个可缓存的线程池，若线程数超过处理所需，缓存⼀段时间后会回收，若线程数不够，则新建线程；
     */
    ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

    /**
     * 3. 创建单个线程数的线程池，它可以保证先进先出的执⾏顺序；
     */
    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

    /**
     * 4. 创建⼀个可以执⾏延迟任务的线程池；
     */
    ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);

    /**
     * 5. 创建⼀个单线程的可以执⾏延迟任务的线程池；
     */
    ExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();

    /**
     * 6. 创建⼀个抢占式执⾏的线程池（任务执⾏顺序不确定）【JDK1.8 添加】
     */
    ExecutorService newWorkStealingPool = Executors.newWorkStealingPool();

    /**
     * 7. 最原始的创建线程池的⽅式，它包含了 7 个参数可供设置
     * corePoolSize：核心线程数
     * maximumPoolSize：最大线程数
     * keepAliveTime：存活时间
     * unit：时间单位
     * workQueue：阻塞队列
     * ThreadFactory：线程工厂
     * RejectedExecutionHandler：拒绝策略
     */
    ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(5, 20 , 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

    /**
     * 拒绝策略:4种jdk提供的拒绝策略+1种自定义的拒绝策略
     * 1. AbortPolicy 直接拒绝，抛出异常。 默认的拒绝策略
     * 2. CallerRunsPolicy 使用调用线程池的线程来执行任务
     * 3. DiscardOldestPolicy 忽略队列第一个任务
     * 4. DiscardPolicy 忽略新来的任务
     * 5. 自定义拒绝策略
     */
    ThreadPoolExecutor threadPoolExecutorTest =
            new ThreadPoolExecutor(5, 20, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100)
                    , threadPoolExecutor.getThreadFactory(), new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println("执行自定义拒绝策略内容");
                }
            });

}
