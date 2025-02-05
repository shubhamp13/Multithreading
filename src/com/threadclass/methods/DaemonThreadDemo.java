package com.threadclass.methods;

public class DaemonThreadDemo extends Thread {
    public void run() {
        for(;;)
        {
            System.out.println("DaemonThreadDemo");
        }
    }

    public static void main(String[] args) {
        DaemonThreadDemo dt = new DaemonThreadDemo();
        dt.setDaemon(true);
        dt.start();
        System.out.println("Main Ends");
    }
}
