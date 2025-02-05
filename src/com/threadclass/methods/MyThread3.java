package com.threadclass.methods;

public class MyThread3 extends  Thread{
    public MyThread3(String name){
        super(name);
    }
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(this.getName() + " is running "+" Priority:"+this.getPriority()+" Count: "+i);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
