package com.hexiaojie.person.center.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_ABC {
    private int num;
    private Lock lock = new ReentrantLock();

    private void printABC(int targetNum){
        for(int i = 0; i < 10;){
            lock.lock();
            if(num % 3 == targetNum){
                num++;
                i++;
                System.out.println(Thread.currentThread().getName());
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock_ABC testLock = new Lock_ABC();
        new Thread(() -> testLock.printABC(0), "A").start();
        new Thread(() -> testLock.printABC(1), "B").start();
        new Thread(() -> testLock.printABC(2), "C").start();
    }
}
