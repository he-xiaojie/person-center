package com.hexiaojie.person.center.thread;

public class Wait_notify_10 {

    private  int num = 0;
    private  int maxnum = 10;
    private static final Object LOCK = new Object();

    private void printNum(int targetNum){
        while (true){
            synchronized(LOCK){
                while(num % 3 != targetNum){
                    if(num >= maxnum){
                        break;
                    }
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(num >= maxnum){
                    break;
                }
                num++;
                System.out.println(Thread.currentThread().getName()+":"+num);
                LOCK.notifyAll();

            }
        }
    }

    public static void main(String[] args) {
        Wait_notify_10 wait_notify_10 = new Wait_notify_10();
        new Thread(() -> {
            wait_notify_10.printNum(0);
        }, "A").start();
        new Thread(() -> {
            wait_notify_10.printNum(1);
        }, "B").start();
        new Thread(() -> {
            wait_notify_10.printNum(2);
        }, "C").start();
    }
}
