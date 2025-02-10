package com.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockDemo
{
    private final Lock lock=new ReentrantLock(true);
    public void accessFile()
    {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" is accessing file");
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" is Releasing The Lock");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairLockDemo fairLockDemo=new FairLockDemo();
        Runnable runnable=()->{
            fairLockDemo.accessFile();
        };
        Thread thread1=new Thread(runnable,"thread 1");
        Thread thread2=new Thread(runnable,"thread 2");
        Thread thread3=new Thread(runnable,"thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
