package com.threadclass.methods;

public class MyThread extends  Thread {

    public void run() {
        System.out.println("Thread-I execution starts");
        try
        {
            Thread.sleep(5000);
            System.out.println("Thread-I  Waiting Completes");
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
        System.out.println("Thread-I execution ends");
    }
}
