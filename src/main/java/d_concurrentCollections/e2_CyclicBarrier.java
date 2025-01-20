package d_concurrentCollections;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 通过使用CyclicBarrier来模拟简单的3个线程之间的等待，结果等待之后调用barrierAction的操作

public class e2_CyclicBarrier {
    public static void main(String[] args) {
        // create a CyclicBarrier with 3 parties,means 3 threads will wait for each other
        CyclicBarrier barrier = new CyclicBarrier(3,() -> {
            System.out.println("All the Threads have reached the barrier, this is a barrier action.");
        });
        // create 3 threads using the FixedThreadPool
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1 ; i <=3 ; i++){
            executor.submit(() -> {
                try{
                    System.out.println("Thread: " + Thread.currentThread().getName() + " is working");
                    Thread.sleep(500); // mimic some operation
                    System.out.println("Thread: " + Thread.currentThread().getName() + " is waiting on barrier");
                    barrier.await(); // wait for other threads to reach the barrier
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + " is continued working");
            });
        }

        // shut down the executor
        executor.shutdown();
        try{
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
