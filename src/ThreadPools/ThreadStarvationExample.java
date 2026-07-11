package ThreadPools;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadStarvationExample {
    private  static AtomicInteger[] completedTasks = new AtomicInteger[3];
    static {
        for (int i = 0; i < completedTasks.length; i++) {
            completedTasks[i] = new AtomicInteger(0);
        }
    }

    static void main(String[] args) throws InterruptedException {
        System.out.println("Without thread pool (potential starvation)");
        withoutThreadPool();
        for (AtomicInteger task : completedTasks){
            task.set(0);
        }
        System.out.println("With thread pool");
//        withThreadPool();
    }
    public static void withoutThreadPool() throws InterruptedException {
        final Object sharedResource = new Object();
        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(new PriorityTask(i % 3,sharedResource));
            thread.setPriority(Thread.MIN_PRIORITY + (i % 3) * 2);
            thread.start();
        }
        Thread.sleep(5000);
        System.out.println("Tasks completed successfully");
        System.out.println("Low Priority : "+ completedTasks[0].get());
        System.out.println("Medium Priority : "+ completedTasks[1].get());
        System.out.println("High Priority : "+ completedTasks[2].get());

    }
    public static void withThreadPool(){

    }

    static class PriorityTask implements  Runnable{
        private final  int priority;
        private final Object sharedResource;

        public PriorityTask(int priority, Object sharedResource) {
            this.priority = priority;
            this.sharedResource = sharedResource;
        }
        public void run(){
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (sharedResource){
                        Thread.sleep(20 + (10 * priority));
                        completedTasks[priority].incrementAndGet();
                    }
                    Thread.sleep(10);
                }
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
