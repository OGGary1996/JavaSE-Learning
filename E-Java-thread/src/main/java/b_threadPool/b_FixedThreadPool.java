package b_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task2 implements Runnable {
    private int ID;
    public Task2(int ID) {
        this.ID = ID;
    }

    @Override
    public void run(){
        System.out.println("Task " + ID + " is running in thread " + Thread.currentThread().getName());
        try{
            Thread.sleep(300); // simulate some work
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class b_FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1 ; i <= 20 ; i++){
            executor.submit(new Task2(i));
        }
        // 运行的结果是所有的任务都在3个线程中执行，线程池中有3个线程

        // 关闭线程池
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("All tasks are completed or the executor is shut down.");
            executor.shutdownNow();
        }
    }
}
