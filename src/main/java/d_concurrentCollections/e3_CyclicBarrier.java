package d_concurrentCollections;

// 本例子通过使用CyclicBarrier来模拟简单的3个线程之间的等待，结果等待之后调用barrierAction的操作
// 通过在每个线程中重复循环调用barrier.await()方法，可以实现多次等待

import java.util.concurrent.*;

public class e3_CyclicBarrier {
    public static void main(String[] args) {
        // create a CyclicBarrier with 3 parties
        CyclicBarrier barrier = new CyclicBarrier(3,() -> {
            System.out.println("All Threads are completed, ready to continue.");
        });

        // create the task
            // 通过循环反复调用barrier.await()方法，实现了多次等待
        Runnable task = () ->{
            for (int i = 1 ; i <= 5 ; i++){
                try{
                 System.out.println("Thread: " + Thread.currentThread().getName() + " is working");
                 Thread.sleep(500);
                 System.out.println("Thread: " + Thread.currentThread().getName() + " is waiting on barrier: " + i);
                 barrier.await();
                }catch (InterruptedException | BrokenBarrierException e){
                    throw new RuntimeException(e);
                }
            }
        };

        // create 3 threads using the FixedThreadPool
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1 ; i <=3 ; i++){
            executor.submit(task);
        }

        // shut down the executor after 10 seconds
        executor.shutdown();
        try{
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
