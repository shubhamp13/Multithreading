package cyclicbarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo
{
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService service= Executors.newFixedThreadPool(4);
        service.submit(new Worker(cyclicBarrier));
        service.submit(new Worker(cyclicBarrier));
        service.submit(new Worker(cyclicBarrier));
        service.shutdown();
    }
}
class Worker implements Runnable
{
    private final CyclicBarrier barrier;
    public Worker(CyclicBarrier barrier)
    {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("Worker " + Thread.currentThread().getId() + " started");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        try
        {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("All Threads are arrived at finish line");
    }
}
