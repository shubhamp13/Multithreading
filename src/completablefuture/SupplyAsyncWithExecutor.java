package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupplyAsyncWithExecutor
{
    public static void main(String[] args) {
        System.out.println("Main started");
        ExecutorService service= Executors.newFixedThreadPool(4);
        CompletableFuture<Integer>future=CompletableFuture.supplyAsync(()->{
            System.out.println("Thread Name:"+Thread.currentThread().getName());
            System.out.println("Thread Id: "+Thread.currentThread().getId());
            System.out.println("Thread Priority:"+Thread.currentThread().getPriority());
            System.out.println("Thread is waiting for completion");
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread Name:"+Thread.currentThread().getName()+" Execution Completed");
            return 18031998;
        },service);
        System.out.println(future.join());

        System.out.println("Main completed");
        service.shutdown();

    }
}
