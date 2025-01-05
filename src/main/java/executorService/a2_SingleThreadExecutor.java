package executorService;
// 本例采用在main class内部创建runnable接口的方式

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a2_SingleThreadExecutor {
    public static void main(String[] args) {
        // create a single thread executor
            // 将Runnable接口的实现传递给submit方法
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 6 ; i++){
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Task " + taskNumber + " is running on Thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }
}
