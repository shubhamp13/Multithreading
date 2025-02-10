package com.callabe;

import java.util.concurrent.*;

public class CallableExample
{
    public static void main(String[] args) {
        Callable callable=()->{
            int sum=0;
            Thread.sleep(2000);
            for (int i=0;i<=10;i++)
            {
                sum+=i;
            }
            return sum;
        };
        try(ExecutorService executor= Executors.newFixedThreadPool(5))
        {
            Future<Integer>result=executor.submit(callable);
            while (!result.isDone())
            {
                Thread.sleep(500);
                System.out.println("Waiting for result!!!!!!!");
            }
            System.out.println(result.get());
        }
        catch(InterruptedException | ExecutionException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
