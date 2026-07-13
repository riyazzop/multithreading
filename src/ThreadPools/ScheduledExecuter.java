package ThreadPools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecuter {
    static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep((2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Running every one secs");
        },1,1, TimeUnit.SECONDS);


        executorService.schedule(() -> {
            String name ="Riyaz";
            System.out.println(name);
        },3,TimeUnit.SECONDS);
//        executorService.shutdown();

        executorService.scheduleWithFixedDelay(() ->{
            try {
                Thread.sleep(2000);
                System.out.println("Task completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },0,1,TimeUnit.SECONDS);
    }


}
