package executoservice.methods;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo
{
    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        for(int i=0;i<100;i++)
        {
            service.submit(()->{
                System.out.println("Task is executing by:"+Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task is execution completed by :"+Thread.currentThread().getName());
            });
        }
        service.shutdown();

    }
}
