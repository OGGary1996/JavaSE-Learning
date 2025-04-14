package f_threadSafetyCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// 本例子通过使用ConcurrentHashMap来实现多线程写入数据，并且使用Future来获取线程的返回值，通过get()方法来等待线程的执行结果

public class c2_ConcurrentHashMap {
    public static void main(String[] args) {
        // create a ConcurrentHashMap
        ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();
        // create 10 threads using the cached thread pool and callable interface
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> resultSet = new ArrayList<>();
        for (int i = 1 ; i <= 10 ;  i++){
            int key = i;
            Future<Integer> result =  executor.submit(() -> {
                for (int j = 1 ; j <= 10 ; j++){
                    map.put(key*100 + j,"Value" + String.valueOf(key));
                }
                return map.size();
            });
            resultSet.add(result);
        }

        // wait all the task to be done then shut down the executor
        try {
            for (Future<Integer> result : resultSet) {
                result.get();
            }
            System.out.println("The final size is: " + map.size());
            executor.shutdown();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            executor.shutdown();
        }
    }
}
