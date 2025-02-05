package com.threadclass.methods;

public class ThreadYieldDemo extends Thread {
    public ThreadYieldDemo(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + getName() + " is running.");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ThreadYieldDemo t1 = new ThreadYieldDemo("Shubham");
        ThreadYieldDemo t2 = new ThreadYieldDemo("Sejal");
        t1.start();
        t2.start();

    }
}
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Shubham is running.
//Thread Sejal is running.
//Thread Shubham is running.
//Thread Sejal is running.
//Thread Shubham is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Sejal is running.

//Thread Shubham is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Shubham is running.
//Thread Shubham is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Sejal is running.
//Thread Sejal is running.

