package com.hexiaojie.person.center.thread;

/**
 * 两个线程交底打印1-100的奇偶数
 * @author hexj-d
 * @date 2023/3/13 13:09
 */

public class Wait_Notify_Odd_Even {

    private volatile int num = 0;

    private Object lock = new Object();

    private void printNum(){
        synchronized (lock){
            while(num < 10){
                System.out.println(Thread.currentThread().getName()+":");
                System.out.println(num++);
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Wait_Notify_Odd_Even wait_notify_odd_even = new Wait_Notify_Odd_Even();
        new Thread(() -> wait_notify_odd_even.printNum(), "A").start();

        Thread.sleep(10);//保证A线程优先启动
        new Thread(() -> wait_notify_odd_even.printNum(), "B").start();
    }
}
