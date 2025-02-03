package com.multithread;

public class PrimeNumber extends  Thread
{
    int range;
    public  PrimeNumber(int range)
    {
        this.range = range;
    }
    @Override
    public  void  run()
    {
        for(int i=0;i<range;i++)
        {
            boolean isPrime = true;
            for(int j=2;j<=i/2;j++)
            {
                if (i%j==0)
                {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
            {
                System.out.println("Prime Number: "+i);
            }
        }
    }
}
