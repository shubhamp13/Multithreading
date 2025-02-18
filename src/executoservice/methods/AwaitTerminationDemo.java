package executoservice.methods;

import java.util.concurrent.*;

public class AwaitTerminationDemo
{
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable=()->{
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        ExecutorService service=Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++)
        {
            service.submit(runnable);
        }
        service.shutdown();
        if(service.awaitTermination(4000,TimeUnit.MILLISECONDS))
        {
            System.out.println("All tasks executed sucessfuly");
        }
        else
        {
            service.shutdownNow();
            System.out.println("Some tasks are not completeds");
        }
    }
}
