public  class SharedResource {

        synchronized void waitExample() {
            System.out.println(Thread.currentThread().getName() + " is waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is resumed after notify");
        }

        synchronized void notifyOne() {
            System.out.println("Notifying the waiting thread");
            notify();
        }
}
void main() {
    SharedResource shared = new SharedResource();
    Thread thread1 = new Thread(shared::waitExample, "Thread-1");
    Thread thread2 = new Thread(shared::waitExample, "Thread-2");
    Thread thread3 = new Thread(() -> {
        try {
            Thread.sleep(1000);
            shared.notifyOne();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shared.notifyOne();
    }, "Thread-3");
    thread1.start();
    thread2.start();
    thread3.start();
}
