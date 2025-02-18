package executoservice.methods;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.*;

public class InvokeAnyDemoWithTime
{
    public static void main(String[] args) {
        Callable<Integer>c1=()->{
            try
            {
                Thread.sleep(1000);
            }catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            return 1;
        };
        Callable<Integer>c2=()->1;
        Callable<Integer>c3=()->1;
        Callable<Integer>c4=()->1;
        Callable<Integer>c5=()->1;
        Callable<Integer>c6=()->1;
        Callable<Integer>c7=()->1;
        Callable<Integer>c8=()->1;

        List<Callable<Integer>> callables= Arrays.asList(c1,c2,c3,c4,c5,c6,c7);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        try
        {
            Integer i = executor.invokeAny(callables, 1, TimeUnit.MILLISECONDS);
            System.out.println(i);
        }
        catch (InterruptedException | ExecutionException |TimeoutException e)
        {
            System.out.println("Time-out exception rises");
            System.out.println(e);
        }
        executor.shutdown();
    }
}
