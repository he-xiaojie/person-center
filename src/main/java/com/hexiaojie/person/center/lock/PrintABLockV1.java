package com.hexiaojie.person.center.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABLockV1 {

    // 1是 A 线程 打印 2 B线程打印
    public static int printFlag = 1;


    public static void main(String[] args) {
          ReentrantLock reentrantLock  = new ReentrantLock();
          Condition  notACondition = reentrantLock.newCondition();
          Condition notBCondition = reentrantLock.newCondition();


          Thread a = new Thread(new Runnable() {
              @Override
              public void run() {
                  while (true){
                      reentrantLock.lock();
                      try{
                          while(printFlag != 1){
                              notACondition.await();
                          }
                          System.out.println("Thread A print");
                          printFlag = 2;
                          notBCondition.signal();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      } finally {
                          reentrantLock.unlock();
                      }
                      try {
                          TimeUnit.SECONDS.sleep(5);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }

              }
          });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    reentrantLock.lock();
                    try{
                        while(printFlag != 2){
                            try {
                                notBCondition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Thread B print");
                        printFlag = 1;
                        notACondition.signal();

                    }finally {
                        reentrantLock.unlock();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        a.start();
        b.start();

    }
}
