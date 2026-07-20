package Volatile;

public class VolatileExample {
    private volatile boolean isRunning = true;
    public  void runTask(){
        System.out.println("Starting execution");
        int count = 0;
        while(isRunning){
//            System.out.println("running");
            count++;
        }
        System.out.println("Count : "+count);
    }

    public void endTask(){
        isRunning = false;
    }

    static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        Thread workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                example.runTask();
            }
        });
        workerThread.start();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread workerThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.endTask();
            }
        });
        workerThread2.start();
    }
}
