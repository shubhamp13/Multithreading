package com.deadlock;

class Pen
{
    public synchronized  void writeWithPenAndPaper(Paper p)
    {
        System.out.println(Thread.currentThread().getName() + "Is using Pen "+this+" And Trying to Acquire Lock of  Paper");
        p.finishedWriting();

    }
    public synchronized  void  finishedWriting()
    {
        System.out.println(Thread.currentThread().getName() + ": Pen writing finished");
    }

    @Override
    public String toString() {
        return " (Pen Object) ";
    }
}
class Paper
{
    public synchronized  void wiriteWithPaperAndPen(Pen p)
    {
        System.out.println(Thread.currentThread().getName() + ": Is using Paper"+this+" And Trying to Acquire lock of Pen"+p);
        p.finishedWriting();
    }
    public synchronized  void  finishedWriting()
    {
        System.out.println(Thread.currentThread().getName() + ": Paper writing finished");
    }

    @Override
    public String toString() {
        return " (Paper Object)";
    }
}
class  Task1 implements Runnable
{
    private Paper paper;
    private Pen pen;

    public Task1(Paper paper, Pen pen) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        synchronized (paper) {
            pen.writeWithPenAndPaper(paper);
        }
    }
}
class  Task2 implements Runnable
{
    private Paper paper;
    private Pen pen;

    public Task2(Paper paper, Pen pen) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        
        paper.wiriteWithPaperAndPen(pen);
    }
}
public class DeadLockExample {
    public static void main(String[] args) {
        Paper paper = new Paper();
        Pen pen = new Pen();
        Task1 task1 = new Task1(paper, pen);
        Task2 task2 = new Task2(paper, pen);
        Thread thread1 = new Thread(task1,"Thread 1");
        Thread thread2 = new Thread(task2,"Thread 2");
        thread1.start();
        thread2.start();
    }
}
