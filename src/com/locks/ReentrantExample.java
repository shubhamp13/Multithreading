package com.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private  final ReentrantLock lock = new ReentrantLock();

    public void outer()
    {
        lock.lock();
        try {
            System.out.println("Inside outer");
            inner();
        }
        finally {
            lock.unlock();
        }
    }

    public void inner() {
        lock.lock();
        try {
            System.out.println("Inside inner");
            System.out.println("Lock Count:"+lock.getHoldCount());
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample obj = new ReentrantExample();
        obj.outer();
    }
}
