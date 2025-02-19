package com.executor.framework.executorservice;

import java.util.concurrent.*;

public class AwaitterminateDemo
{
    public static void main(String[] args) {
        ExecutorService service=Executors.newFixedThreadPool(2);

        service.submit(()->{
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        service.submit(()->{
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        service.shutdown();
        try {
            if(service.awaitTermination(5000,TimeUnit.MILLISECONDS))
            {
                System.out.println("All threads executed within time");
            }
            else
            {
                System.out.println("Time out reached");
            }
        }catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
