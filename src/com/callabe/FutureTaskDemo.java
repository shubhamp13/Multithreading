package com.callabe;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo
{
    public static void main(String[] args) {
        Callable<Integer> callable = () -> {
            int mul = 1;
            for (int i = 1; i <= 5; i++)
                mul *= i;
            return mul;
        };
        FutureTask<Integer>futureTask=new FutureTask<>(callable);
        Thread thread=new Thread(futureTask);
        thread.start();
        try {
            System.out.println("Thread is running");
             Integer result=futureTask.get();
            System.out.println(result);
        }catch (InterruptedException | ExecutionException e)
        {
            Thread.currentThread().interrupt();
        }
    }

}
