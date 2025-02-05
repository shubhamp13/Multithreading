package com.threadclass.methods;

public class ThreadInterruption extends Thread{
    public void run(){
        try {
            System.out.println("Thread Is Sleeping");
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            System.out.println("Thread Is Interrupted");
        }
    }

    public static void main(String[] args) {
        ThreadInterruption t1 = new ThreadInterruption();
        t1.start();
        System.out.println("Calling Interruption");
        t1.interrupt();
        Thread.yield();
//        System.out.println("Main Ends");
    }
}
