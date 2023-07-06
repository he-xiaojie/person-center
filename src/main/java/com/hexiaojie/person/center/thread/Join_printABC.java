package com.hexiaojie.person.center.thread;

public class Join_printABC {

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++){
            Thread t1 = new Thread(new PrintJoinABC(null), "A");
            Thread t2 = new Thread(new PrintJoinABC(t1), "B");
            Thread t3 = new Thread(new PrintJoinABC(t2), "C");
            t1.start();
            t2.start();
            t3.start();
            Thread.sleep(10);
        }
    }

    public static class PrintJoinABC implements Runnable{
        private Thread beforeThread;

        public PrintJoinABC(Thread beforeThread){
            this.beforeThread = beforeThread;
        }
        @Override
        public void run() {
            if(beforeThread != null){
                try {
                    beforeThread.join();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
