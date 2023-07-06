package com.hexiaojie.person.center.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThreadExecute {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        CountDownLatch countDownLatch3 = new CountDownLatch(1);

        //创建并启动线程1
        Thread thread1 = new Thread(new MyThread(countDownLatch1),"T1");
        thread1.start();
        countDownLatch3.await();

        //创建并启动线程2
        Thread thread2 = new Thread(new MyThread(countDownLatch2),"T2");
        thread2.start();
        countDownLatch2.await();

        //创建并启动线程3
        Thread thread3 = new Thread(new MyThread(countDownLatch3),"T3");
        thread3.start();
        countDownLatch3.await();

    }

    static class MyThread implements Runnable{

        private CountDownLatch countDownLatch;

        public MyThread(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            try {
                //开始模拟任务
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" is running");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                //完成一个线程计数器-1
                countDownLatch.countDown();
            }
        }
    }
}
