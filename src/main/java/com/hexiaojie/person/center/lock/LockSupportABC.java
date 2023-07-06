package com.hexiaojie.person.center.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportABC {

    static Thread t1 = null, t2= null;
    public static void main(String[] args) {

        char[] char1 = "1234567".toCharArray();
        char[] char2 = "ABCDEFG".toCharArray();

         t1 = new Thread(() ->{
            for(char c : char1){
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }

        }, "t1");

         t2 = new Thread(() ->{
            for(char a : char2){
                LockSupport.park();
                System.out.print(a);
                LockSupport.unpark(t1);
            }

        }, "t2");

         t1.start();
         t2.start();
    }
}
