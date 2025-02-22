package completablefuture.exercise;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Write a program that runs a task asynchronously using runAsync(). The task should print "Hello, CompletableFuture!" and then complete.
public class Question1{
    public static void main(String[] args) {

        ExecutorService service= Executors.newSingleThreadExecutor();
        CompletableFuture.runAsync(()->{
            System.out.println("Hello,CompletableFuture");
        },service);
        System.out.println("Main thread");
        service.shutdown();

    }
}
