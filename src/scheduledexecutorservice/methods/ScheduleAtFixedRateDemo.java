package scheduledexecutorservice.methods;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRateDemo
{

    public static void main(String[] args) {
        ScheduledExecutorService schedule= Executors.newScheduledThreadPool(4);
        schedule.scheduleAtFixedRate(()->{
            long currentTime = System.currentTimeMillis();
            System.out.println("Task Started At:"+(currentTime/1000)+" Seconds");
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread Working Time :"+(System.currentTimeMillis()-currentTime));
        },0,3,TimeUnit.SECONDS);
        schedule.schedule(()->{
            System.out.println(Thread.currentThread().getName()+" Is Shutting down the scheduler");
            System.out.println("Shutting down the scheduler");
            schedule.shutdown();
        },20,TimeUnit.SECONDS);
    }
}
