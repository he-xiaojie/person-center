package com.hexiaojie.person.center.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestABC {
    private int num = 0;


    private static final Object LOCK = new Object();

    private void print(int targetNum){
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK){
                while(num % 3 != targetNum){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(Thread.currentThread().getName());
                ++num;
                LOCK.notifyAll();
            }
        }
    }

    public static Lock lock = new ReentrantLock();
    public static Condition condition1 = lock.newCondition();
    public static Condition condition2 = lock.newCondition();
    public static Condition condition3 = lock.newCondition();

    private void print(int targetNum, Condition currentThread, Condition nextThread){
        for(int i = 0; i < 10; i++){
            lock.lock();
            while(num % 3 != targetNum){
                try {
                    currentThread.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            num++;
            System.out.println(Thread.currentThread().getName());
            nextThread.signal();
            lock.unlock();
        }
    }

    private void print(int targetNum, Thread currentThread, Thread nextThread){

    }
    public static void main(String[] args) {
        /**
         * synchronized + wait +notify实现
         */
        /*TestABC testABC = new TestABC();
        new Thread(()-> testABC.print(0), "A").start();
        new Thread(()-> testABC.print(1), "B").start();
        new Thread(()-> testABC.print(2), "C").start();*/


        /**
         * Lock + Condition实现
         */
//        TestABC testABC = new TestABC();
//        new Thread(()-> testABC.print(0, condition1, condition2), "A").start();
//        new Thread(()-> testABC.print(1, condition2, condition3), "B").start();
//        new Thread(()-> testABC.print(2, condition3, condition1), "C").start();

        /**
         * LockSupport 实现
         */

        Thread t1 = new Thread(() -> System.out.println("A"));

        Thread t2 = new Thread(() -> System.out.println("B"));

        t1.start();
        t2.start();
    }
}
