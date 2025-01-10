package d_concurrentCollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 本例子演示如何使用BlockingQueue进行简单的生产者消费者模型

class Resource3 {
    private int queueCapacity;
    private BlockingQueue<Integer> queue;

    public Resource3(int queueCapacity){
        this.queueCapacity = queueCapacity;
        this.queue = new ArrayBlockingQueue<>(queueCapacity);
    }

    public void produce(){
        for (int i = 1 ; i <= 999 ; i++){
            try{
                queue.put(i);
                Thread.sleep(100);
                System.out.println("Produced : " + i);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void consume(String name){
        while(true){
            try{
                int value = queue.take();
                Thread.sleep(500);
                System.out.println(name + " Consuming : " + value);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}

public class a2_BlockingQueue {
    public static void main(String[] args) {
        Resource3 resource = new Resource3(10);
        Thread producer = new Thread(() -> {
            resource.produce();
        });

        Thread consumer1 = new Thread(() -> {
            resource.consume("Consumer 1");
        });

        Thread consumer2 = new Thread(() -> {
            resource.consume("Consumer 2");
        });

        producer.start();
        consumer1.start();
        consumer2.start();

    }
}
