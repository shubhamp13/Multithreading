package executoservice.methods;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.List;

public class InvokeAllDemoWithTime
{
    public static void main(String[] args)
    {
        Callable<String>c1=()->{
            try {
                Thread.sleep(5150);
            }
            catch(InterruptedException e) {
                System.out.println("Interrupted");
                Thread.currentThread().interrupt();
            }
            return "Shubham PAndit Puri";
        };
        Callable<String>c2=()->"Sejal Pravin Patankar";
        Callable<String>c3=()->"Shrikant Navnath Surve";
        Callable<String>c4=()->"Omkar Ramesh Patil";
        List<Callable<String>> callables= Arrays.asList(c1,c2,c3,c4);
        ExecutorService service= Executors.newFixedThreadPool(3);
        try {

            List<Future<String>>futures=service.invokeAll(callables,5200, TimeUnit.MILLISECONDS);
            for(Future<String>f:futures)
            {
                System.out.println(f.get());
            }
        }
        catch(InterruptedException | ExecutionException e)
        {
            System.out.println("Tasks are not completed");
//            Thread.currentThread().interrupt();
        }
        service.shutdown();
        System.out.println("Shutdown");
    }
}
