package com.executor.framework.executorservice;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnable
{
    public static void main(String[] args) {
        Runnable runnable = ()->System.out.println(Thread.currentThread().getName()+" This is a Runnable");
        try(ExecutorService service= Executors.newSingleThreadExecutor())
        {
       
           Future<?>future= service.submit(runnable);
            System.out.println(future.get());
        }
        catch (InterruptedException | ExecutionException e)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main thread exiting");
    }
}
