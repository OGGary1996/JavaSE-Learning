package e_threadPool;

import java.util.concurrent.*;

class Hello implements Callable<String>{
    private String name;
    public Hello(String name){
        this.name = name;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);// 模拟任务执行时间
        return "Hello " + name + " from Thread " + Thread.currentThread().getName();
    }
}

public class e1_CallableFuture {
    public static void main(String[] args) {
        // create a fixed thread executor
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> result = executor.submit(new Hello("World"));
        try{
            System.out.println(result.get());
        }catch(InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }finally {
            executor.shutdown();
        }

    }
}
