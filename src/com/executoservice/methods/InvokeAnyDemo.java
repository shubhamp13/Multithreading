package executoservice.methods;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyDemo
{
    public static void main(String[] args) {
        Callable<Object>c1=()->198;
        Callable<Object>c2=()->"Shubham";
        Callable<Object>c3=()->3.14;
        List<? extends Callable<Object>> list= Arrays.asList(c1,c2,c3);
        Collections.shuffle(list);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        try {

            Object result=executor.invokeAny(list);
            if(result instanceof Integer)
            {
                System.out.println((Integer)result);
            }
            else if(result instanceof String)
            {
                System.out.println((String)result);
            }
            else if(result instanceof  Double)
            {
                System.out.println((Double)result);
            }
            else
            {
                System.out.println("Invalid result");
            }
        }
        catch (InterruptedException | ExecutionException e)
        {
            Thread.currentThread().interrupt();
        }
        executor.shutdown();
    }
}
