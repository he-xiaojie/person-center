package com.hexiaojie.person.center.thread;

public class PrintABD {

    private int num = 0;

    private static final Object LOCK = new Object();

    private void printNum(int targetNum){

        for(int i = 0; i < 10; i++){
            synchronized (LOCK){
                while(num % 3 != targetNum){
                    try {
                        //对象锁等待
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //获取对象锁的线程
                System.out.println(Thread.currentThread().getName());
                num++;
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABD test = new PrintABD();
        new Thread(() -> test.printNum(0), "A").start();
        new Thread(() -> test.printNum(1), "B").start();
        new Thread(() -> test.printNum(2), "C").start();
    }
}
