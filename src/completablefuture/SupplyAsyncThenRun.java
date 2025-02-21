package completablefuture;

import java.util.concurrent.CompletableFuture;

public class SupplyAsyncThenRun
{
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2999);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            String name=Thread.currentThread().getName();
            System.out.println("Thread Name in supplyAsync is "+name );
            return name;
        }).thenRun(()->{
            System.out.println("Thread Name In thenRun is "+Thread.currentThread().getName());
        }).join();
        System.out.println("Main ends");
    }
}
