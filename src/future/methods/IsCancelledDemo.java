package future.methods;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class IsCancelledDemo {
    public static void main(String[] args)
    {
        Callable<Integer>callable=()->9;
        ExecutorService service= Executors.newSingleThreadExecutor();
        Future<Integer> future=service.submit(callable);
        future.cancel(false);
        System.out.println(future.isCancelled());
        service.shutdown();
    }
}
