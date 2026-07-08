
class MyThread extends  Thread{
    @Override
    public  void run(){
        for (int i = 0; i <5; i++) {
            System.out.println("Thread : "+Thread.currentThread().threadId()+" is running "+i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

void main() {
    MyThread thread1 = new MyThread();
    thread1.start();
}