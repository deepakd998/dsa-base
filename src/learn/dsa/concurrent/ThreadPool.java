package learn.dsa.concurrent;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPool {
    BlockingDeque<Runnable> taskQueue;
    boolean isShutdownInitiated;
    int count;

    public ThreadPool(int count) {
        this.count = count;
        this.taskQueue= new LinkedBlockingDeque<>(count);
        for(int i=1;i<=count;i++){
        ThreadPoolThread threadPoolThread = new ThreadPoolThread(taskQueue,this);
        threadPoolThread.setName("Thread- "+i);
        threadPoolThread.start();
        }
    }
    public synchronized void execute(Runnable task) throws Exception {

            if(this.isShutdownInitiated){
                throw  new Exception("Thread pool shut down");
            }
            this.taskQueue.put(task);
        System.out.println("task added");
    }

    public synchronized void shutdown(){
        this.isShutdownInitiated = true;
        System.out.println("ThreadPool SHUTDOWN initiated.");
    }

    public static void main(String[] args) throws Exception {
        ThreadPool pool= new ThreadPool(3);
        pool.execute(new Task());
        pool.execute(new Task());
        pool.execute(new Task());
        pool.execute(new Task());
        pool.execute(new Task());
        pool.shutdown();
    }
}
class Task implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"EXECUTING");
    }
}
class ThreadPoolThread extends Thread{
    BlockingQueue<Runnable> taskQueue;
    ThreadPool threadPool;
    public ThreadPoolThread(BlockingQueue<Runnable> taskQueue,ThreadPool threadPool){
        this.taskQueue=taskQueue;
        this.threadPool=threadPool;
    }

    @Override
    public void run() {
        try {
            while (true){
                Runnable r=taskQueue.take();
                System.out.println(Thread.currentThread().getName()+" has started Working");
                r.run();
                if(this.threadPool.isShutdownInitiated&&threadPool.taskQueue.size()==0){
                    this.interrupt();
                }
                System.out.println(Thread.currentThread().getName()+" Executed task");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
