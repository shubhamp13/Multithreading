package com.threadclass.methods;

public class Demo
{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            myThread.join();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("After Execution of MyThread This line will execute");
        System.out.println("Main Ends");
    }
}
