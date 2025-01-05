package b_executorService;

import java.util.concurrent.*;

public class e2_CallableFuture {
    public static void main(String[] args) {
        // create a fixed thread executor
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> result = executor.submit(() -> {
            Thread.sleep(5000);// 模拟任务执行时间
            return "Hello World from Thread " + Thread.currentThread().getName();
        });
        try{
            System.out.println(result.get(4000, TimeUnit.MILLISECONDS)); // 4秒后超时,抛出错误
        } catch(InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        } catch (TimeoutException e){ // 抛出超时异常
            System.out.println("Task is taking too long, cancelling the task");
            result.cancel(true); // 超时后取消任务
        } finally {
            executor.shutdown(); // 无论超时还是完成任务，都要关闭线程池
        }

    }
}
