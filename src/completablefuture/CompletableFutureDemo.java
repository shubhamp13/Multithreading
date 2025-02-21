package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo
{
    public static void main(String[] args) {

        CompletableFuture<Void>completableFuture=CompletableFuture.
                runAsync(()->{
            System.out.println(Thread.currentThread().getName()+" Is Executing Asynchronously");
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        });
//        completableFuture.join();
//        try {
//            completableFuture.get();
//        } catch (InterruptedException | ExecutionException e) {
//            Thread.currentThread().interrupt();
//        }
        System.out.println("Main Thread continue");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main Execution ends");
    }
}
