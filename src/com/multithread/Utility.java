package com.multithread;

public class Utility
{
    public static void main(String[] args)
    {
        PrimeNumber primeNumber=new PrimeNumber(20000);
        PerfectNumber perfectNumber=new PerfectNumber(20000);
        Thread thread1=new Thread(perfectNumber);
        primeNumber.start();
        thread1.start();

    }
}
