package com.locks;

public class Main
{
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Runnable runnable = ()->{
            account.withdraw(500.00);
        };
        Thread thread = new Thread(runnable,"Thread-1");
        Thread thread2 = new Thread(runnable,"Thread-2");
        thread.start();
        thread2.start();

    }
}
