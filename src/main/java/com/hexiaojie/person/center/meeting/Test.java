package com.hexiaojie.person.center.meeting;

public class Test {

    public volatile int num = 0;

    public static final Object LOCK = new Object();

    private void printABC(int targetNum){

        for(int i =0; i <10; i++){
            synchronized (LOCK){
                while(num % 3 != targetNum){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName());
                num++;
                LOCK.notifyAll();
            }

        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(() -> test.printABC(0), "A").start();
        new Thread(() -> test.printABC(1), "B").start();
        new Thread(() -> test.printABC(2), "C").start();


    }
}
