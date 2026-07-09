package ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPUIntensiveTask {
    static void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                long res = performTask();
                System.out.println("Thread : "+ Thread.currentThread().getName() + " is finished task : "+res);

            });
        }
        executorService.shutdown();

    }
    private static long performTask(){
        long sum = 0;
        for (int i = 0; i < 1_000_000_0; i++) {
            sum += Math.sqrt(i);
        }
        return sum;
    }
}
