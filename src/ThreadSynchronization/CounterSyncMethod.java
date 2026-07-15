public class CounterSync {
    private int count = 0;
    public synchronized void increment(){
        System.out.println(Thread.currentThread().getName() + " is entered the method block to increment count value ");
        count++;
        System.out.println("The value of count : "+count + " on "+Thread.currentThread().getName() + " operation");

    }
}

void main() {
    CounterSync counter = new CounterSync();
    for (int i = 0; i < 5; i++) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.increment();
            }
        });
        thread.start();

    }
}
