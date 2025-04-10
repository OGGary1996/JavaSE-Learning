package e_executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b_FixedThreadExecutor {
    public static void main(String[] args) {
        // create a fixed thread executor
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1 ; i < 8; i++){
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
