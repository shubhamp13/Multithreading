package com.executor.framework.executorservice;

public class Test
{
    public  static  boolean isPrime(int n)
    {
        for(int i=2;i<n;i++)
        {
            if (n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(4));
    }
}
