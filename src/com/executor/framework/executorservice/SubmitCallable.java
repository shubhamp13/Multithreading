package com.executor.framework.executorservice;

import java.util.concurrent.*;

public class SubmitCallable
{
    public static void main(String[] args) {
        Callable<String>callable=()->{
            Thread.sleep(2000);
            return "This is shubham pandit puri";
        };
        try(ExecutorService service= Executors.newSingleThreadExecutor())
        {
            Future<String>future=service.submit(callable);
            while (!future.isDone())
            {
                Thread.sleep(500);
                System.out.println("Waiting for Result");
            }
            System.out.println(future.get());
        }catch (InterruptedException | ExecutionException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
