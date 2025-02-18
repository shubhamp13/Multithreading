package executoservice.methods;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownDemo
{
    public static void main(String[] args) {

        Callable<Integer>callable=()->{
            try
            {
                Thread.sleep(5000);
            }catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println("Execution completed");
            return 1;
        };
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.submit(callable);
        executorService.shutdown();
    }
}
