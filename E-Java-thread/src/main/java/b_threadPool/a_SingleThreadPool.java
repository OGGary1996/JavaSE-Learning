package b_threadPool;
// 本例采用在main class外部单独创建runnable接口的方式

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private int ID;
    public Task(int ID) {
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

public class a_SingleThreadPool {
    public static void main(String[] args){
        // 创建线程池，本例子采用单线程池 SingleThreadExecutor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 假设循环创建并提交10个任务
        for(int i = 1 ; i <= 10 ;i++){
            executor.submit(new Task(i));
        }
        // 运行的结果是所有的任务都在同一个线程中执行，线程池中只有一个线程

        // 关闭线程池
        executor.shutdown();
        try{
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)){ // 如果5秒之内池中的任务还没有完成，则强制关闭
                executor.shutdownNow(); // 强制关闭，立即生效
            }
        }catch (InterruptedException e){ // 如果线程关闭出现了异常，则打印异常信息
            e.printStackTrace();
        }finally {
            System.out.println("All tasks are completed or the executor is shut down.");
            executor.shutdownNow();
        }
    }
}
