package completablefuture;

import java.util.concurrent.CompletableFuture;

public class SupplyAsyncThenApply
{
    public static void main(String[] args) {
        CompletableFuture<Integer>future=CompletableFuture.supplyAsync(()->25).
                thenApply((x)->x*x).
                thenApply((x)->(int)Math.sqrt(x)/5);
        System.out.println(future.join());

        CompletableFuture.
                supplyAsync(()->5).
                thenApply(x->x*x).
                thenApply(x->x+100).
                thenAccept(System.out::println)
                .join();
        System.out.println("Main ends here");
    }
}
