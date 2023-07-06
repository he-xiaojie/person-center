package com.hexiaojie.person.center.thread;

import java.util.concurrent.RecursiveTask;

public class ForkJoinThreadTest {
    public static void main(String[] args) {

    }


    private class MyForkJoinTask extends RecursiveTask<Long> {

        private long startNum;

        private long endNum;

        public MyForkJoinTask(long startNum, long endNum){
            this.startNum = startNum;
            this.endNum = endNum;
        }

        private static final long THRESHOLD = 1000;

        @Override
        protected Long compute() {
            if (endNum -startNum <= THRESHOLD){
                long sum = 0;
                for(long i = startNum; i <= endNum; i++){
                    sum += i;
                }
                return sum;
            }else{
                long middle = startNum + (endNum - startNum) / 2;
                MyForkJoinTask left = new MyForkJoinTask(startNum, middle);
                MyForkJoinTask right = new MyForkJoinTask(middle +1, endNum);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }
}
