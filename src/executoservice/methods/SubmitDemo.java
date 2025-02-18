package executoservice.methods;

import java.util.concurrent.*;

public class SubmitDemo
{
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        ExecutorService service= Executors.newFixedThreadPool(3);
        Runnable runnable=()->{
            Thread.currentThread().setName("Runnable Thread");
            System.out.println(Thread.currentThread().getName());
        };
        Callable <String>callable=()->{
            Thread.currentThread().setName("Callable Thread");
            String threadName=Thread.currentThread().getName();
            return threadName;
        };

        service.submit(runnable);
        Future<String>threadName=service.submit(callable);
        try
        {
            System.out.println(threadName.get());
        } catch (ExecutionException | InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));

        service.shutdown();

    }
}
