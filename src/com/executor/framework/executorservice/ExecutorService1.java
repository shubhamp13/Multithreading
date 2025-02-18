package com.executor.framework.executorservice;

import java.util.concurrent.*;

public class ExecutorService1 {
    public static void main(String[] args) {
        //Using submit method() with Callable(Interface)

        Callable<String> callable = () -> "This is shubham puri";
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<String> future = service.submit(callable);
            String res = future.get();
            System.out.println("Result: " + res);
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }

        //Using submit() method with Runnable Interface:
        Runnable runnable = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " This is Runnable Interface");};

        try(ExecutorService service = Executors.newSingleThreadExecutor()) {
            Future<?> future = service.submit(runnable);
            while (!future.isDone()) {
                System.out.println("Waiting for future");
            }

        }
    }
}
