package d_concurrentCollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 本案例演示如何使用BlockingQueue进行简单的生产者消费者模型

public class a1_BlockingQueue {
    public static void main(String[] args) {
        // create a blocking queue
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        // create 2 Threads, which represent produce and consume
        Thread producer = new Thread(() -> {
            for (int i = 0 ; i < 10 ; i++){
                try{
                    queue.put(i); // put the element into the queue
                    System.out.println("Produced : " + i);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while(true){
                try{
                    int value = queue.take(); // take the element from the queue
                    Thread.sleep(500);
                    System.out.println("Consuming : " + value); // take the element from the queue
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        });

        // start the threads
        producer.start();
        consumer.start();
    }
}
