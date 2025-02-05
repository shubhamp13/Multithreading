package com.synchronize;

public class Demo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread myThread1 = new MyThread(counter);
        MyThread myThread2 = new MyThread(counter);
        myThread1.start();
        myThread2.start();
        try {
            myThread1.join();
            myThread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}
