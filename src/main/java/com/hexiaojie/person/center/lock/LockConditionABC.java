package com.hexiaojie.person.center.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionABC {
    private int num;

    private static Lock lock = new ReentrantLock();

    private static Condition c1 = lock.newCondition();

    private static Condition c2 = lock.newCondition();

    private static Condition c3 = lock.newCondition();

    private void printABC(int targetNum, Condition currentThread, Condition nextThread) {
        for (int i = 0; i < 10; ) {
            lock.lock();
            try {
                while (num % 3 != targetNum) {
                    currentThread.await();
                }
                num++;
                i++;
                System.out.println(Thread.currentThread().getName());
                nextThread.signal();
            }catch(Exception e){
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockConditionABC test1 = new LockConditionABC();
        new Thread(() -> test1.printABC(0, c1,c2), "A").start();
        new Thread(() -> test1.printABC(1, c2,c3), "B").start();
        new Thread(() -> test1.printABC(2, c3,c1), "C").start();
    }
}
