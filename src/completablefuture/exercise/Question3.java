package completablefuture.exercise;

import java.util.concurrent.CompletableFuture;

//Start with an integer input (int number = 4).
//Multiply it by 2 asynchronously.
//        Add 10 to the result.
//Print the final computed value.
public class Question3 {
    public static void main(String[] args) {
        int number=4;
      CompletableFuture<Integer>future=  CompletableFuture.supplyAsync(()->number*2).
                thenApply((value)->value+10);
        System.out.println(future.join());
    }
}
