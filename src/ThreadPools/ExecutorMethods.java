package ThreadPools;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorMethods {
    static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<String>> tasks = List.of(() -> "Task 1",() -> "Task 2");
        try {
            List<Future<String>> results=executorService.invokeAll(tasks);
            List<Future<String>> timeoutResults = executorService.invokeAll(tasks,1, TimeUnit.SECONDS);
            System.out.println(results.get(0).get());
            System.out.println(timeoutResults);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(re);
        executorService.shutdown();
    }



}
