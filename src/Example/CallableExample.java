package Example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<String> {
    String name;

    MyCallable(String name) {
        this.name = name;
    }

    public String call(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            result.append("Callable : ").append(name).append(" is running ").append(i+" Id: ").append(Thread.currentThread().threadId()).append("\n");
            try {
                Thread.sleep(500);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
}

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<String> callable1 = new MyCallable("Thread 11");
        Callable<String> callable2 = new MyCallable("Thread 22");
        try {
            Future<String> future1 = executor.submit(callable1);
            Future<String> future2 = executor.submit(callable2);
            System.out.println("Result from first task : ");
            System.out.println(future1.get());
            System.out.println("Result from second task : ");
            System.out.println(future2.get());

        } catch (Exception e) {
            
        }
        
    }
    
}