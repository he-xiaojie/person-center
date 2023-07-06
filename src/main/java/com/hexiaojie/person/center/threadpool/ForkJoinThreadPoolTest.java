package com.hexiaojie.person.center.threadpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 *
 * ThreadPool Executor 包含4部分
 *  1. 线程处理器（ThreadPool） 用于创建并管理线程池，包括创建线程池、销毁线程池，添加新任务
 *  2. 工作线程（PoolWorker） 线程池中的线程，在没有任务时处于等待状态，可以循环的执行任务
 *  3. 任务接口（Task） 每个任务必须实现的接口，以供工作线程调度任务的执行。它主要规定了任务的入口，任务执行完
 *  以后的收尾工作，任务的执行状态等。
 *  4. 任务队列（taskQueue）用于存放没有处理的任务，提供一种缓存机制
 *
 *  工作方式
 *  线程中有一个工作队列，队列中包含了要分配给各个线程的工作（任务）。当线程空闲时，就会从队列中认领工作。由于线程
 *  资源的创建与销毁开销很大。所以线程池允许线程的重用，减少创建与销毁线程的次数，提高效率
 */


/**
 * ForkJoinPool Executor
 *
 * ForkJoinPool组成类
 * 1. ForkJoinPool：充当fork/join框架里面的管理者，最原始的任务都要交给它才能处理。它负责控制整个fork/join有多少workerThread；
 * workerThread的创建，激活都是由它来掌控的。它还负责workQueue队列的创建和分配；每当创建一个workerThread，它负责分配相应的workQueue，
 * 然后它把接到的活都交给workerThread去处理，它可以说是整个fork/join的容器。
 * 2. ForkJoinWorkerThread：fork/join里面真正干活的工人，本质是一个线程。里面有一个ForkJoinPool.workQueue的队列存放这它要干的活，
 * 在开始接活之前它要向ForkJoinPool注册（registerWorker），拿到相应的workQueue。然后就从workQueue里面拿任务来处理。
 * 他是依附于ForkJoinPool而存活，如果ForkJoinPool销毁了，它也会跟着结束。
 * 3. ForkJoinPool.workQueue：双端队列就是它，它负责存储接收的任务。
 * 4. ForkJoinTask：代表fork/join里面的任务类型，我们一般用它的两个子类RecursiveTask、RecursiveAction。
 * 这两个区别在于RecursiveTask任务有返回值，RecursiveAction没有返回值。任务的处理逻辑包括任务的切分都集中在compute()方法里面。
 *
 * 工作方式
 * 使用一直分治算法，递归地将任务分割成更小的子任务，其中阈值可配置，然后把子任务分配给不同的线程并发执行，最后再把结果组合起来。该方法常见于数组于集合的运算。
 * 由于提交的任务不一定能够递归的分割成ForkJoinTask，且ForkJoinTask执行时间不等长，所以ForkJoinPool使用一种工作窃取的算法，
 * 允许空闲的线程“窃取”分配给另一线程的工作，由于工作无法平均分配并执行，所以工作窃取算法能更高效地利用硬件资源。
 */
public class ForkJoinThreadPoolTest {
    //todo 计算1-100的和
    public static void main(String[] args) {
            long startTime = System.currentTimeMillis();
            //jdk 1.8
            long sum = LongStream.rangeClosed(0, 100).parallel().sum();
            System.out.println(sum + "long花费时间：" + (System.currentTimeMillis() - startTime));

            //jdk 1.7
            ForkJoinPool fjp = new ForkJoinPool();
            MyForkJoin myForkJoin = new MyForkJoin(0, 100);
            Long invoke = fjp.invoke(myForkJoin);
            System.out.println(invoke);


    }


    public static class MyForkJoin extends RecursiveTask<Long> {
        private long start;

        private long end;

        private static final long THRESHOLD = 10;

        public MyForkJoin(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            } else {
                long middle = (start + end) / 2;
                MyForkJoin left = new MyForkJoin(start, middle);
                MyForkJoin right = new MyForkJoin(middle + 1, end);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }

}
