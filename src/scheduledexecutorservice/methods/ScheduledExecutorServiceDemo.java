package scheduledexecutorservice.methods;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo
{
    public static void main(String[] args) {

        ScheduledExecutorService schedule= Executors.newScheduledThreadPool(1);
        schedule.schedule(()-> System.out.println("Hello This will execute after 5 seconds delay")
                ,5
                ,TimeUnit.SECONDS);
        schedule.shutdown();
    }
}
