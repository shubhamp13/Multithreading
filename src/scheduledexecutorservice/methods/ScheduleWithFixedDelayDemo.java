package scheduledexecutorservice.methods;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleWithFixedDelayDemo
{
    static  int counter=0;
    public static void main(String[] args) {
        ScheduledExecutorService schedule= Executors.newScheduledThreadPool(1);

        schedule.scheduleWithFixedDelay(()->{
            ++counter;
            long currentTime = System.currentTimeMillis();
            System.out.println("Task-"+counter+" is started At:"+(currentTime/1000)+" Seconds");
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task-"+counter+" is finished At:"+(currentTime-(System.currentTimeMillis()))+" Seconds");
        },0,5, TimeUnit.SECONDS);
    }
}
