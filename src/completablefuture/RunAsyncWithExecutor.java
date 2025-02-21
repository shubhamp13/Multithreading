package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncWithExecutor
{
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(4);
        CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread Name:"+Thread.currentThread().getName()+" Is executing the task");
        },service);
        System.out.println("main ends");
        service.shutdown();
        System.out.println("Main ends =====");
    }
}
