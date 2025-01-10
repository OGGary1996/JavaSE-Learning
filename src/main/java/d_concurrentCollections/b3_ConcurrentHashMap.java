package d_concurrentCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// 本例子通过使用ConcurrentHashMap来实现计数器，通过使用原子操作merge()方法来实现多线程安全的计数

public class b3_ConcurrentHashMap {
    public static void main(String[] args) {
        // create a ConcurrentHashMap
        ConcurrentHashMap<String,Integer> counter = new ConcurrentHashMap<>();
        // create a thread that increments the counter
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> resultSet = new ArrayList<>();

        // create a callable task
            /*
             * merge() method:
             * If the specified key is not already associated with a value or is associated with null,
             * associates it with the given non-null value（1）.
             * Otherwise, replaces the associated value with the results of the given remapping function（Integer :: sum）,
             * merge()方法：
             * 如果指定的键尚未与值关联，或者与null关联，则将其与给定的非null值关联。
             * 否则，将关联值替换为给定重新映射函数的结果，
             */
        Callable<Integer> task = () -> {
            for (int i = 0 ; i < 1000 ; i++){
                counter.merge("count", 1 , Integer::sum);
            }
            return counter.get("count");
        };

        // submit the task to the executor
        for (int i = 1 ; i <= 3 ; i++){
            resultSet.add(executor.submit(task));
        }

        // wait for the result
        try {
            for (Future<Integer> result : resultSet){
                System.out.println(result.get());
            }
            System.out.println("Total count: " + counter.get("count"));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
