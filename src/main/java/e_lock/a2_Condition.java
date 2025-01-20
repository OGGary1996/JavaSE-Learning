package e_lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 本例子采用在同一个class内部定义生产和消费方法，
 * 在main方法中设置两个线程，一个生产，一个消费，通过在线程中调用生产和消费方法实现生产者消费者模型
 */

public class a2_Condition {
    private final int maxCap = 10;
    private final Queue<Integer> resources = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition bufferNotFull = lock.newCondition();
    private final Condition bufferNotEmpty = lock.newCondition();

    public void produce(int item) throws InterruptedException{
        lock.lock();
        try{
            while(resources.size() == maxCap){
                System.out.println("Buffer is full, waiting for consumer to consume");
                bufferNotFull.await();
            }
            System.out.println("Produced: " + item + "Current size: " + resources.size());
            resources.add(item);
            bufferNotEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException{
        lock.lock();
        try{
            while(resources.isEmpty()){
                System.out.println("Buffer is empty, waiting for producer to produce");
                bufferNotEmpty.await();
            }
            System.out.println("Consumed: " + resources.poll() + "Current size: " + resources.size());
            bufferNotFull.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        a2_Condition simulation = new a2_Condition();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            try{
                for (int item = 0 ; item < 100 ; item++){
                    simulation.produce(item);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            try{
                for (int i = 0 ; i < 100 ; i++){
                    simulation.consume();
                    Thread.sleep(500);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        executor.shutdown();
        try{
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
