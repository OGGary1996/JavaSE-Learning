package d_threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class d_ScheduledThreadPool {
    public static void main(String[] args) {
        // create a scheduled thread executor
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            // example1: schedule a task to run after 2 seconds
        executor.schedule(() -> {
            System.out.println("Task 1 is running on Thread " + Thread.currentThread().getName());
        },2000, TimeUnit.MILLISECONDS);

            // example2: schedule a task to run after 3 second and repeat every 1 sec
                // 这种方式不会等待上一个任务执行完毕，而是每隔一段时间就执行一次，不管上一个任务是否执行完毕
        executor.scheduleAtFixedRate(() -> {
           System.out.println("Task 2 is running on Thread " + Thread.currentThread().getName());
        },3000,1000,TimeUnit.MILLISECONDS);

            // example3: schedule a task to run after 3 second, repeat every 1 sec after the task is completed
                // 这种方式会等待上一个任务执行完毕，再等待一段时间再执行下一个任务
        executor.scheduleWithFixedDelay(() -> {
            System.out.println("Task 3 is runnin on Thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // 模拟每个任务耗时2秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },3000, 1000, TimeUnit.MILLISECONDS); // 3秒后开始执行，每次任务执行完毕后，等待1秒再执行下一个任务


        // shut down the executor
            // give the executor 20 seconds to complete all tasks, after 20 sec, forcefully shutdown
            // executor.awaitTermination();方法返回值是boolean，如果线程池在指定时间内完成了关闭，则返回true，否则返回false
        executor.shutdown();
        try{
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
