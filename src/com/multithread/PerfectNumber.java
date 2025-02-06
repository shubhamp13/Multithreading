package com.multithread;

import java.io.IOException;

public class PerfectNumber implements Runnable {

    private  int  range;
    public PerfectNumber(int range)
    {
        this.range = range;
    }
    @Override
    public void run() {
        for(int i=1;i<=range;i++)
        {
            int sum=0;
            for(int j=1;j<=i/2;j++)
            {
                if(i%j==0)
                {
                    sum+=j;
                }
            }
            if (sum==i)
            {
                System.out.println("Perfect number: "+i);
            }
        }
    }
}
