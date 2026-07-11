package ThreadPools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolQueueExample {
    static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                5,
                2,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 15; i++) {

            int finalI = i;
            executor.execute(() -> {
                System.out.println("Executing task : "+ (finalI + 1));
                try{
                    Thread.sleep(2500);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
    }
}
