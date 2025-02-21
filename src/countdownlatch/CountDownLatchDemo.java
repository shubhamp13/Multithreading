package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo
{
    public static void main(String[] args)
    {
        int numberOfServices=2;
        CountDownLatch countDownLatch=new CountDownLatch(numberOfServices);
        ExecutorService service= Executors.newFixedThreadPool(2);
        service.submit(new PrimeNumber(countDownLatch));
        service.submit(new PerfectNumber(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main execution resume");
        service.shutdown();
    }
}

class PrimeNumber implements Runnable{
    private CountDownLatch countDownLatch;
    public PrimeNumber(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run()
    {
        for(int i=0;i<1000;i++)
        {
            if(isPrime(i))
                System.out.println("Prime Number:"+i);
        }
        countDownLatch.countDown();
    }
    private static  boolean isPrime(int number) {
        for(int i=2;i<=number/2;i++)
        {
            if(number%i==0)
                return false;
        }
        return true;
    }
}
class PerfectNumber implements Runnable{
    private CountDownLatch latch;
    public  PerfectNumber(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
        for(int i=0;i<1000;i++)
        {
            if(isPerfect(i))
                System.out.println("Perfect Number:"+i);
        }
        latch.countDown();
    }
    private  static  boolean isPerfect(int num)
    {
        int sum=0;
        for(int i=1;i<=num/2;i++)
        {
            if(num%i==0)
            {
                sum+=i;
            }
        }
        return sum==num;
    }
}
