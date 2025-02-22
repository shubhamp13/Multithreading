package completablefuture;

import java.util.concurrent.CompletableFuture;

public class ThenComposeDemo
{
    public static void main(String[] args) {

       CompletableFuture<CompletableFuture<Integer>>nestedFuture= CompletableFuture.supplyAsync(()->10).
                thenApply((value)->CompletableFuture.
                        supplyAsync(()->value*value));
        System.out.println(nestedFuture.join().join());

       CompletableFuture<Integer>future= CompletableFuture.supplyAsync(()->18).
                thenCompose((value)->
                        CompletableFuture.supplyAsync(()->value*value));
        System.out.println(future.join());
    }
}
