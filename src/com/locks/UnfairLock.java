package com.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLock
{
    private final Lock lock = new ReentrantLock(true);
    public void accessResource()
    {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is accessing resource");
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " is unlocked");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        UnfairLock lock = new UnfairLock();
        Runnable runnable=()->{
            lock.accessResource();
        };
        Thread thread=new Thread(runnable,"thread-1");
        Thread thread2=new Thread(runnable,"thread-2");
        Thread thread3=new Thread(runnable,"thread-3");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
