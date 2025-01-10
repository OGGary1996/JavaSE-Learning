package d_concurrentCollections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c1_CopyOnWriteArray {
    public static void main(String[] args) {
        // create a CopyOnWriteArray
        CopyOnWriteArrayList<Integer> nums = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 7, 9});
        // create 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                nums.add(i);
                System.out.println("Thread 1 add: " + i);
            }
        });
        executor.submit(() -> {
            for (int num : nums){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(num);
            }
        });

        // shut down the executor
        executor.shutdown();
    }
}
