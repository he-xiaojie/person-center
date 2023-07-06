package com.hexiaojie.person.center.thread;

public class TestThread {

    private static boolean running =true;

    private static int count =0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(running){
                    count++;
                }
                System.out.println("count:"+ count);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                running = false;
            }
        });

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        thread1.join();
        thread2.join();

    }
}
