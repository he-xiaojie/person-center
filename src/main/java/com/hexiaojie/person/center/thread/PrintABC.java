package com.hexiaojie.person.center.thread;

/**
 * @author hexj-d
 * @date 2023/3/13 11:58
 */

public class PrintABC {

    private int num;
    private static final Object LOCK = new Object();

    private void printABC(int targetNum){
        for(int i = 0; i< 10; i++){
            synchronized (LOCK){
                while(num % 3 != targetNum){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }


    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();
        new Thread(() -> printABC.printABC(0), "A").start();
        new Thread(() -> printABC.printABC(1), "B").start();
        new Thread(() -> printABC.printABC(2), "C").start();
    }
}
