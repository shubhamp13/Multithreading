package com.locks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo
{
    private int count = 0;
    private final ReadWriteLock lock=new ReentrantReadWriteLock();
    private final Lock readLock=lock.readLock();
    private final Lock writeLock=lock.writeLock();

    public int getCount()
    {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Read Lock Count: " + count);
            return count;
        }
        finally {
            System.out.println(Thread.currentThread().getName() + ": Read Lock Releasing");
            readLock.unlock();
        }
    }
    public  void setCount()
    {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Writing Value To Count");
            ++count;
        }
        finally {
            System.out.println(Thread.currentThread().getName() + ":Write Lock Released");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockDemo demo=new ReadWriteLockDemo();

        Runnable runnable=()->{
            for (int i = 0; i < 10; i++) {
                demo.setCount();
            }
        };
        Runnable runnable1=()->{
            for (int i = 0; i < 10; i++) {
                demo.getCount();
            }
        };
        Thread t1=new Thread(runnable,"Writer Thread-I");
        Thread t2=new Thread(runnable1,"Reader Thread-I");
        Thread t3=new Thread(runnable1,"Reader Thread-II");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(demo.getCount());


    }
}
