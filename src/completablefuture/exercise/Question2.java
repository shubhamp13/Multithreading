package completablefuture.exercise;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Create a CompletableFuture<Integer> that returns the square of a given number asynchronously.
//Input: int number = 5;
//The computation should be non-blocking.
//Print the final result when it completes.
public class Question2
{
    public static void main(String[] args) {
        int number=5;
        ExecutorService service= Executors.newSingleThreadExecutor();
        CompletableFuture<Integer>res=CompletableFuture.
                supplyAsync(()->number*number,service);
        System.out.println(res.join());
        service.shutdown();
    }
}
