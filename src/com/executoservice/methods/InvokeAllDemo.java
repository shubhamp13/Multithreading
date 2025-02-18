package executoservice.methods;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.List;

public class InvokeAllDemo
{
    public static void main(String[] args) {

        Callable<Integer>c1=()->1;
        Callable<Integer>c2=()->8;
        Callable<Integer>c3=()->3;
        Callable<Integer>c4=()->1;
        Callable<Integer>c5=()->9;
        Callable<Integer>c6=()->9;
        Callable<Integer>c7=()->8;

        List<Callable<Integer>> callables= Arrays.asList(c1,c2,c3,c4,c5,c6,c7);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            List<Future<Integer>>futures=executor.invokeAll(callables);
            for(Future f:futures)
            {
                System.out.println(f.get());
            }

        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
        executor.shutdown();
    }
}
