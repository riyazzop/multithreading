package Example;

public class ThreadStates {
    static void main(String[] args) {
        //New State
        Thread mythread = new Thread(()->{
            System.out.println("Hello");
            System.out.println(Thread.currentThread().getName());
        },"Thread1");
        //Runnable state
        //Running state if CPU allocates resources to it
        mythread.start();
        //Blocked state if the thread is waiting to enter synchronized block
        //Waiting state if the thread is waiting for others to notify it, no timeout specified
        //Timed waiting state , entered when Thread.sleep(timeout), Object.wait(timeout) called
        //Terminated , when the thread is completed execution or forcefully terminated

    }
}