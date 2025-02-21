package future.methods;

 
import java.util.concurrent.*;

public class GetDemoTime
{
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(numThreads);
        Callable<Integer>callable=()->{
            try {
                System.out.println("Waiting for Execution");
                Thread.sleep(4000);
            }catch (InterruptedException e) {
                System.out.println("InterruptedException");
                Thread.currentThread().interrupt();
            }
            return 18031998;
        };
        Future<Integer>future =service.submit(callable);
        try {

            int a=future.get(10, TimeUnit.MILLISECONDS);
            System.out.println(a);
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException occured");
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e)
        {
            System.out.println("ExecutionException occured");
            Thread.currentThread().interrupt();
        }
        catch (TimeoutException e) {
            System.out.println("TimeoutException occured");
            Thread.currentThread().interrupt();
        }
        finally {
            service.shutdown();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime));

    }
}
