package com.thread.communications;

class SharedResource
{
    private  int data;
    private boolean isAvailabe;
    public  synchronized  void consume()
    {
        try {
            while (!isAvailabe)
            {
                wait();
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        isAvailabe = false;
        System.out.println(Thread.currentThread().getName() + " consumed: "+data);
        notify();
    }

    public synchronized  void produce(int data)
    {
        try {
            while (isAvailabe)
            {
                wait();
            }
        }catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        isAvailabe = true;
        this.data = data;
        System.out.println(Thread.currentThread().getName() + " produced: "+data);
        notify();
    }
}

class  Producer implements Runnable
{
    private final SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++)
        {
            sharedResource.produce(i);
        }
    }
}
class Consumer implements Runnable
{
    private final SharedResource sharedResource;
    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    public void run()
    {
        for(int i=1;i<=10;i++)
        {
            sharedResource.consume();
        }
    }
}
public class InterThreadCommunication {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);
        Thread producerThread = new Thread(producer,"Producer-Thread");
        Thread consumerThread = new Thread(consumer,"Consumer-Thread");
        producerThread.start();
        consumerThread.start();
    }
}