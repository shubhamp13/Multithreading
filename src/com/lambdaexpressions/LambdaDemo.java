package com.lambdaexpressions;

public class LambdaDemo
{
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Hello World");
            }
        };
        Thread t = new Thread(r);
        t.start();

        //lambda expression
        Runnable r2=()->{
            for(int i=1;i<=10;i++)
            {
                System.out.println("Hello World");
            }
        };
        Thread t2 = new Thread(r2);
        t2.start();
    }
}
