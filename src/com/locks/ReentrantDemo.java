package com.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo
{
    int counter = 0;
    private final Lock lock = new ReentrantLock(true);
    public void increment()
    {
        lock.lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " Incremented Value of Counter " + counter);

        }
        finally {
            System.out.println(Thread.currentThread().getName() + " Unlocking Lock");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantDemo demo = new ReentrantDemo();
        Runnable runnable =()->{
            for (int i = 0; i < 10; i++) {
                demo.increment();
            }
        };
        Thread t1 = new Thread(runnable,"Thread1");
        Thread t2 = new Thread(runnable,"Thread2");
        t1.start();
        t2.start();
    }
}
