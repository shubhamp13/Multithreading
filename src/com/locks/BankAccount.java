package com.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount
{
    private double balance=10000.00;
    private final Lock lock=new ReentrantLock();

    public void withdraw(double amount)
    {
        System.out.println(Thread.currentThread().getName()+" Trying To Withdraw "+amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS))
            {
                if(balance>=amount)
                {
                    System.out.println(Thread.currentThread().getName()+" Withdrawing "+amount);
                    try {
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println(e);
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }
                    balance=balance-amount;
                    System.out.println(Thread.currentThread().getName()+" Transaction Successful!!!");
                    System.out.println(Thread.currentThread().getName()+" Balance: "+balance);

                }
                else
                {
                    System.out.println(Thread.currentThread().getName()+" Transaction Failed!!! Insufficient Balance");
                }
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+" Please Try After 10 seconds....");
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
