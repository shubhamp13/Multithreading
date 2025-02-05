package com.threadclass.methods;

public class MyThread2 extends Thread{
    public void run(){
        try {
            MainThread.thread.join();

        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        for(int i=0; i<10; i++){
            System.out.println("MyThread2");
        }
    }
}
