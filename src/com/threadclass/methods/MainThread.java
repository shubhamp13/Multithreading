package com.threadclass.methods;

public class MainThread
{
    public  static final Thread thread=Thread.currentThread();
    public static void main(String[] args)
    {
        MyThread2 myThread2=new MyThread2();
        myThread2.start();
        for (int i=0;i<10;i++)
        {
            System.out.println("Main Thread");
        }
        System.out.println("Main Thread ends");
    }
}
