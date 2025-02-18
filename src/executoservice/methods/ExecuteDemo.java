package executoservice.methods;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteDemo
{
    public static void main(String[] args) {

        //Demo Of execute method of Executor interface

        ExecutorService service= Executors.newSingleThreadExecutor();
        Runnable r1=()->{
            Thread.currentThread().setName("Shubham");
            System.out.println(Thread.currentThread().getName());
        };

        Callable callable=()->"This is shubham pandit puri";
        //Executor interface execute() method will take Runnable as an argument
        service.execute(r1);
        //if we do nit call shytdown method after execute then program will not be stop automatically
        service.shutdown();
    }
}
