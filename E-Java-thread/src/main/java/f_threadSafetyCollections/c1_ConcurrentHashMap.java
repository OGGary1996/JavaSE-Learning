package f_threadSafetyCollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 本例子展示了如何使用ConcurrentHashMap来实现多线程写入数据

public class c1_ConcurrentHashMap {
    public static void main(String[] args) {
        // create a ConcurrentHashMap
        ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();
        // create 10 threads by using the CachedThreadPool
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 1 ; i <= 10 ; i++){
            int key = i;
            executor.submit(() -> {
                for(int j = 1 ; j <= 10 ; j++){
                map.put(key*100 + j,"Value" + String.valueOf(key));
                }
            });
        }

        // wait all the task to be done then shut down the executor
        executor.shutdown();
        try{
            if(!executor.awaitTermination(10, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        // print the map
        System.out.println(map.size());
    }
}
