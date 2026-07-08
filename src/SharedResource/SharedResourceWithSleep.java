public  class SharedResourceWithSleep {
    synchronized void sleepExample(){
        System.out.println(Thread.currentThread().getName() + " is entering to sleep");
        try{
            System.out.println(Thread.currentThread().getName()+" is sleeping for 5s");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() +" is woke up after sleep");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}

void main() {
    SharedResourceWithSleep shared = new SharedResourceWithSleep();
    Thread sleeper1= new Thread(shared::sleepExample,"Sleeper 1");
    Thread sleeper2 = new Thread(shared::sleepExample,"Sleeper 2");
    sleeper1.start();
    sleeper2.start();
}
