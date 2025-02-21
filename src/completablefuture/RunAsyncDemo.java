package completablefuture;

import java.util.concurrent.CompletableFuture;

public class RunAsyncDemo
{
    public static void main(String[] args) {
        CompletableFuture<Void>future=CompletableFuture.runAsync(()->{
            System.out.println("Thread Name: "+Thread.currentThread().getName()+" Is Executing Task");
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println("Execution of task is completed");
        });

        System.out.println("Main execution continue");
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main Execution Ends");
    }
}
