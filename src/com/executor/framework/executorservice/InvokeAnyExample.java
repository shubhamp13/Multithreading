package com.executor.framework.executorservice;




import  java.util.List;
 
import java.util.Arrays;
import java.util.concurrent.*;

public class InvokeAnyExample
{
    public static void main(String[] args) {
        try (ExecutorService service= Executors.newFixedThreadPool(2))
        {
           List<Callable<String>>callableList= Arrays.asList(()->{
               Thread.sleep(1000);
               return "Task -1";
           },()->{
               Thread.sleep(1000);
               return "Task -2";
           },()->{
               Thread.sleep(1000);
               return "Task -3";
           });
       String any= service.invokeAny(callableList);
       System.out.println(any);
        }
        catch (ExecutionException |InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
