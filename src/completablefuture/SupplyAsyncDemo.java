package completablefuture;

import  java.util.concurrent.CompletableFuture;
public class SupplyAsyncDemo
{
    public static void main(String[] args) {

        CompletableFuture<String>future=CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("Thread Name: "+Thread.currentThread().getName());
                    try {
                        Thread.sleep(5000);
                    }catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    return "This is shubham pandit puri";
                }
        );
        System.out.println(future.join());
        System.out.println("Main Execution Ends here");
    }
}
