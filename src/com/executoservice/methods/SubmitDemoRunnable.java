package executoservice.methods;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitDemoRunnable
{
    public static void main(String[] args) {

        Runnable runnable=()->{
            Thread.currentThread().setName("Runnable Thread");
            System.out.println(Thread.currentThread().getName());
        };
        ExecutorService service= Executors.newSingleThreadExecutor();
        Future<String>future =service.submit(runnable,"Runnable Task is completed");
        try
        {
            System.out.println(future.get());
        }
        catch (InterruptedException | ExecutionException e)
        {
            Thread.currentThread().interrupt();
        }

    }
}
