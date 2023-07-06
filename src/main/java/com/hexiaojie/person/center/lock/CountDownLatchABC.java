package com.hexiaojie.person.center.lock;


import java.util.concurrent.CountDownLatch;

public class CountDownLatchABC {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {

        final Object o = new Object();

        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (o){
                for (char c : chars1) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "A").start();

        new Thread(() ->{
            synchronized (o){
                for (char c : chars2) {
                    System.out.print(c);
                    countDownLatch.countDown();
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"B").start();
    }
}
