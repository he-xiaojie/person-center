package com.hexiaojie.person.center.leetcode;

public class Test {
    private int num = 0;
    private static final Object LOCK = new Object();

    private void print(int targetNum){
        for(int i = 0; i < 100;i++){
            synchronized (LOCK){
                while(num % 2 != targetNum){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("线程"+Thread.currentThread().getName()+"打印："+num);
                num++;
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(() -> test.print(0), "A").start();
        new Thread(() -> test.print(1), "B").start();
    }

}
