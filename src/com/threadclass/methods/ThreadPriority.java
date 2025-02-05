package com.threadclass.methods;

public class ThreadPriority
{
    public static void main(String[] args) {
        MyThread3 t1=new MyThread3("Shubham");
        MyThread3 t2=new MyThread3("Sejal");
        MyThread3 t3=new MyThread3("Shrikant");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
