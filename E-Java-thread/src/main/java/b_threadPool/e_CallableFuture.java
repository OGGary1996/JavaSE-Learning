package b_threadPool;

import java.util.List;
import java.util.concurrent.*;

class Hello implements Callable<String>{
    private String name;
    public Hello(String name){
        this.name = name;
    }
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(500);// 模拟任务执行时间
        return "Hello " + name + " from Thread " + Thread.currentThread().getName();
    }
}

public class e_CallableFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> resultSet = new CopyOnWriteArrayList<>(); // 用于存放结果
        for(int i = 1 ; i <= 10 ;i++){
            Future<String> result = executor.submit(new Hello("@" + i + "@"));
            // 将结果添加到结果集中
            resultSet.add(result);
        }

        // 遍历结果集，并阻塞等待结果
        for(Future<String> result : resultSet){
            try{
                System.out.println(result.get());
            }catch (ExecutionException | InterruptedException e){
                e.printStackTrace();
            }
        }

        // 关闭线程池
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        }catch (InterruptedException e){
            System.out.println("Executor was interrupted");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
