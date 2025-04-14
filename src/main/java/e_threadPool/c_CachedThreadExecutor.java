package e_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c_CachedThreadExecutor {
    public static void main(String[] args) {
        // create a cached thread executor
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 1; i < 20 ; i ++){
            int taskID = i;
            executor.submit(() -> {
                System.out.println("Task " + taskID + " is running on Thread " + Thread.currentThread().getName());
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }
}
