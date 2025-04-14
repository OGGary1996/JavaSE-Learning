package e_threadPool;
// 本例采用在main class外部单独创建runnable接口的方式

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    public int taskNumber;
    public Task(int taskNumber){
        this.taskNumber = taskNumber;
    }
    @Override
    public void run() {
        System.out.println("Task " + taskNumber + " is running on Thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class a1_SingleThreadExecutor {
    public static void main(String[] args) {
        // create a single thread executor
            // 将Runnable接口的实现传递给submit方法
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 6; i++){
            executor.submit(new Task(i));
        }
        executor.shutdown();
    }
}
