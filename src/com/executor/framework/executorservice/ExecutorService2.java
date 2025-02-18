package com.executor.framework.executorservice;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorService2
{
    public static void main(String[] args)
    {
        Callable<String> callable1=()->"This is shubham Puri";
        Callable<String> callable2=()->"I am MCA Student";
        Callable<String> callable3=()->"I have done Bachelors in Computer Applications";
        List<Callable<String>>list = Arrays.asList(callable1, callable2, callable3);
        try (ExecutorService executor = Executors.newFixedThreadPool(2))
        {
           List<Future<String>>futures= executor.invokeAll(list);
           for(Future<String>f:futures)
           {
               System.out.println(f.get());
           }
        }
        catch (InterruptedException | ExecutionException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
