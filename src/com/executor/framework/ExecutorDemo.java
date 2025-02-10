package com.executor.framework;

import java.util.concurrent.*;

public class ExecutorDemo
{
    private static  long factorial(int n)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        long result = 1;
        for(int i = 1; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        for(int i=1; i<=10; i++)
        {
            final int finalI = i;
             Future<Long>result=executorService.submit(()->{
                return factorial(finalI);
            });
            System.out.println(result.get());
        }
        executorService.shutdown();

    }
}

