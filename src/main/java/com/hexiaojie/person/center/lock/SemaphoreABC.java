package com.hexiaojie.person.center.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreABC {

    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(0);
    private static Semaphore s3 = new Semaphore(0);

    private void printABC(Semaphore currentThread, Semaphore nextThread){
        for(int i = 0; i < 10; i++){
            try {
                //申请获得信号量
                currentThread.acquire();
                System.out.println(Thread.currentThread().getName());
                nextThread.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        SemaphoreABC test = new SemaphoreABC();
        new Thread(() -> test.printABC(s1, s2), "A").start();
        new Thread(() -> test.printABC(s2, s3), "B").start();
        new Thread(() -> test.printABC(s3, s1), "C").start();
    }
}
