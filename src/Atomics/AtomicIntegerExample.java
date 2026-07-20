package Atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private AtomicInteger counter = new AtomicInteger(0);
    public void increment(){
        int val = counter.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " incremented counter by "+val);
    }

    static void main(String[] args) {
        AtomicIntegerExample example = new AtomicIntegerExample();
        int noOfThreads = 10;
        for (int i = 0; i < noOfThreads; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        example.increment();
                    }
                }
            }).start();
        }
    }
}
