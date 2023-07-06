package com.hexiaojie.person.center.lock;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueABC {

    public static void main(String[] args) {
        char[] chars1 = "1234567".toCharArray();
        char[] chars2 = "ABCDEFG".toCharArray();

        TransferQueue<Character>  queue = new LinkedTransferQueue<>();

        new Thread(()->{
            try {
                for (char c : chars1) {
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                for (char c : chars2) {
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "B").start();
    }


}
