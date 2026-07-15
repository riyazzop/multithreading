
public class CounterSyncBlock {
    private int count = 0;
    private final Object lock = new Object();
    public void increment(){
        System.out.println(Thread.currentThread().getName()+ "(non synchronised) is entered to the method increment");
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"(synchronized block) acquired lock ");
            count++;
            System.out.println(Thread.currentThread().getName()+" performed operation and releasing lock");
        }
        System.out.println("Non synchronized");
    }
}

void main() {
    CounterSyncBlock counter = new CounterSyncBlock();
    for (int i = 0; i < 5; i++) {
        Thread thread  = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.increment();
            }
        },"Thread - "+(i + 1));
        thread.start();
    }
}