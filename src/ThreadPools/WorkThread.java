package ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkThread implements Runnable {
    private final int taskId;

    WorkThread(int taskId) {
        this.taskId = taskId;
    }

    public void run() {

        System.out.println(Thread.currentThread().getName() + " is processing task " + taskId);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " is finished task");
    }
}


class First {
    void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new WorkThread(i));
        }
        executorService.shutdown();
    }
}
