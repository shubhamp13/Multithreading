package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComtDownLatchDemo2
{
    public static void main(String[] args)
    {
        int noOfServices=10;
        CountDownLatch countDownLatch=new CountDownLatch(noOfServices);

        ExecutorService service= Executors.newFixedThreadPool(4);
        for(int i=0;i<noOfServices;i++)
        {
            service.submit(new Task(countDownLatch));
        }
        try
        {
            countDownLatch.await();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main Resumes here");
        service.shutdown();
    }

}
class Task implements Runnable{
    private CountDownLatch countDownLatch;
    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    public void run() {
        try
        {
            System.out.println(Thread.currentThread().getName()+" Is Executing... Task");
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        countDownLatch.countDown();
    }
}
