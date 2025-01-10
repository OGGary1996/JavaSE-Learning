package d_concurrentCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// 本例子展示了如何使用ConcurrentHashMap来模拟cache的获取，并且使用Future来获取线程的返回值，通过get()方法来等待线程的执行结果

public class b4_ConcurrentHashMap {
    // create a ConcurrentHashMap
    private static final ConcurrentHashMap<String,String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // create 10 threads using the CachedThreadPool
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<?>> resultSet = new ArrayList<>();

        for (int i = 1 ; i <= 10 ; i++){
            int threadID = i;
            Future<?> result = executor.submit(() -> {
                String key = "Key @ " + threadID;
                for (int j = 1 ; j <= 3 ; j++){ // 每个线程尝试3次获取key对应的cache值
                    String value = getCachedValue(key);
                    System.out.println("Thread: " + Thread.currentThread().getName() + " Key: " + key + " Value: " + value);
                }
            });
            resultSet.add(result);
        }
        // wait for all the tasks to be done then shut down the executor
        try{
            for (Future<?> result : resultSet){
                result.get(); // 等待所有的任务完成
            }
            executor.shutdown();
        }catch (InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }finally {
            executor.shutdown();
        }
    }

    public static String getCachedValue(String key){
        if (cache.get(key) == null){ // 如果没有查找到key对应的value，则使用compute方法模拟计算一个cache的值
            String value = compute(key);
            cache.put(key,value); // 计算完成之后将key和value存入cache
            return value;
        }else { // 如果找到key对应的value，则直接返回这个value
            return cache.get(key);
        }
        // 以上所有的操作等同于如下院子操作
        // return cache.computeIfAbsent(key, k -> compute(k));
    }

    public static String compute(String key){
        try{
            Thread.sleep(500); // 模拟计算时间
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        return "Value for " + key;
    }
}
