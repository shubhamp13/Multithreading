package executoservice.methods;

import java.util.concurrent.*;

public class ShutDownNowDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable <Integer> callable=()->{
            double d=Math.random()*1000;
            int a=(int)d;
            return a ;
        };
        ExecutorService service= Executors.newSingleThreadExecutor();
        Future<Integer>res=service.submit(callable);
        System.out.println(res.get());
        service.shutdownNow();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(service.isTerminated());
    }
}
