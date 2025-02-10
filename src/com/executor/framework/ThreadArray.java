package com.executor.framework;

import java.util.concurrent.Executors;

public class ThreadArray {
    public static void main(String[] args) {

        long startTime=System.currentTimeMillis();
        Thread[] threads=new Thread[10];
        for(int i=1;i<=10;i++)
        {
            final int data=i;
            threads[i-1]=new Thread(()->{
                System.out.println(factorial(data));
            },"Thread-"+data);
            threads[i-1].start();
        }
        for(int i=1;i<=10;i++)
        {
            try {
                threads[i-1].join();
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();

            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println("Total time: " + (endTime-startTime));
    }





    private static  long factorial(int n) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(Thread.currentThread().getName());
        return result;

    }
}
