package com.executor.framework.executorservice;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.*;
public class ExecutorService3
{
    public static void main(String[] args) {
        Callable<String> callable1=()->{
            System.out.println(Thread.currentThread().getName()+" is executing");
            Thread.sleep(2000);
            return " Shubham Pandit Puri ";
        };
        Callable<String>callable2=()->{
            System.out.println(Thread.currentThread().getName()+" is executing");
            Thread.sleep(2000);
            return " Sejal Pravin Patankar ";
        };
        Callable<String>callable3=()->{
            System.out.println(Thread.currentThread().getName()+" is executing");
            Thread.sleep(2000);
            return " Shrikant Navnath Surve ";
        };
       List<Callable<String>>list= Arrays.asList(callable1,callable2,callable3);
       try (ExecutorService service= Executors.newFixedThreadPool(3)){
           String future = service.invokeAny(list, 2100, TimeUnit.MILLISECONDS);
           System.out.println(future);
       }
       catch (Exception e)
       {
           Thread.currentThread().interrupt();
       }
    }
}
