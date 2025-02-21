package future.methods;

import java.util.concurrent.*;

public class CancelDemo {
    public static void main(String[] args) {
        ExecutorService service=Executors.newSingleThreadExecutor();
        Callable<Void>callable=()->{
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+" Is Executing....!");
                }catch (InterruptedException e){
                    System.out.println("InterruptedException caught");
                    Thread.currentThread().interrupt();
                }
            }
            return null;
        };
        Future<Void> future=service.submit(callable);
        try {
            Thread.sleep(20000);
            boolean cancel=future.cancel(false);
            if(cancel){
                System.out.println("tasks has been cancelled");
            }
            else
            {
                System.out.println("tasks has not been cancelled");
            }
        }
        catch (InterruptedException e){
            System.out.println("InterruptedException caught");
        }
        finally {
            service.shutdown();
        }

    }
}
