package learn.dsa.concurrent;

public class SemaphorCustom {
    int permits;
    public SemaphorCustom(int permits){
        this.permits=permits;
    }

    public synchronized void acquire() throws InterruptedException {
        if(permits>0){
            permits--;
        }else {
           this.wait();
           permits--;
        }
    }

    public synchronized void release(){
        permits++;
        if(permits>0){
            this.notify();
        }
    }

    public static void main(String[] args) {
        SemaphorCustom sp= new SemaphorCustom(1);
        SemaphorCustom sc= new SemaphorCustom(0);
        new Thread(new Producer(sp,sc)).start();
        new Thread(new Consumer(sp,sc)).start();
    }
}
class Producer implements Runnable{
    SemaphorCustom sp;
    SemaphorCustom sc;
    public Producer(SemaphorCustom sp,SemaphorCustom sc) {
        this.sp = sp;
        this.sc=sc;
    }

    @Override
    public void run() {
        try {
            sp.acquire();
            for (int i = 1; i < 5; i++) {

                System.out.println("Produced" + i);

            }
            sc.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    SemaphorCustom sp;
    SemaphorCustom sc;
    public Consumer(SemaphorCustom sp,SemaphorCustom sc) {
        this.sp = sp;
        this.sc=sc;
    }

    @Override
    public void run() {
        try {
            sc.acquire();
            for (int i = 1; i < 5; i++) {

                System.out.println("Consumed" + i);
            }
            sp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
