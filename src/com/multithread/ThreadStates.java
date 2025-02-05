package com.multithread;

public class ThreadStates extends Thread
{
    public void  run()
    {
        try {
            System.out.println("RUNNING");

            System.out.println("FINISHED");
            Thread.sleep(2000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStates threadStates = new ThreadStates();
        System.out.println(threadStates.getState());
        System.out.println("Main Thread State Is "+Thread.currentThread().getState());
        threadStates.start();
        Thread.sleep(200);
        System.out.println(threadStates.getState());
        threadStates.join();//after execution of this thread then only next statement will be executed
        System.out.println(threadStates.getState());

    }
}
