package future.methods;

import java.util.concurrent.*;

public class IsDoneDemo
{
    public static void main(String[] args) {
        Callable<Integer>callable=()->{
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
            return 8793;
        };
        try(ExecutorService service= Executors.newSingleThreadExecutor()){
            Future<Integer> future=service.submit(callable);
            System.out.println(future.get());
            if(future.isDone()){
                System.out.println("Task is Done");
            }
            else{
                System.out.println("Task is not Done");
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("InterruptedException caught");
        }
        catch (ExecutionException e)
        {
            System.out.println("ExecutionException caught");
        }
    }
}
