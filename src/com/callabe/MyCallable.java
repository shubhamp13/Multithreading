package com.callabe;

import java.util.ArrayList;
import java.util.concurrent.*;

public class MyCallable implements Callable<ArrayList<Integer>>
{
    private final int start;
    private final int end;
    public MyCallable(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
    @Override
    public ArrayList<Integer> call() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = start; i <= end; i++)
        {
            if(isPrime(i))
                list.add(i);
        }
        return list;
    }
    public static boolean isPrime(int number)
    {
        for (int i = 2; i <= number/2; i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)   {
        Callable<ArrayList<Integer>> callable = new MyCallable(1,200);
        try(ExecutorService excutor=Executors.newFixedThreadPool(2)) {
            Future<ArrayList<Integer>> result = excutor.submit(callable);
            for (Integer x : result.get()) {
                System.out.println(x);
            }
        }
        catch (InterruptedException | ExecutionException e)
        {
            Thread.currentThread().interrupt();
        }

    }
}
