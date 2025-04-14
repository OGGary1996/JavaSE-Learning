package d_threadSafetyCollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 本案例演示如何使用BlockingQueue进行简单的生产者消费者模型

class DemoRestaurant {
    // 使用线程安全的阻塞队列，不需要手动使用synchronized关键字和手动加锁
    // 这里使用ArrayBlockingQueue作为阻塞队列的实现，在达到5和0时，自动阻塞；
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); // 创建一个大小为5的阻塞队列

    // 生产方法
    public void produce() throws InterruptedException {
        // 由于BlockingQueue自动阻塞的特性，不需要像使用synchronized关键字时需要手动判断是否达到边界；也不需要像使用lock时需要判断条件进行唤醒
        System.out.println(Thread.currentThread().getName() + "Starts producing...");
        Thread.sleep(1000); // 模拟生产时间
        queue.put(1);
        System.out.println(Thread.currentThread().getName() + "Produced 1 item, queue size: " + queue.size());
    }

    // 消费方法
    public void consume() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "Starts consuming...");
        Thread.sleep(500); // 模拟消费时间
        queue.take(); // FIFO
        System.out.println(Thread.currentThread().getName() + "Consumed 1 item, queue size: " + queue.size());
    }
}

// 线程类
class Producer implements Runnable {
    private final DemoRestaurant demoRestaurant;
    public Producer(DemoRestaurant demoRestaurant) {
        this.demoRestaurant = demoRestaurant;
    }
    @Override
    public void run() {
        try {
            while (true) {
                demoRestaurant.produce();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private final DemoRestaurant demoRestaurant;
    public Consumer(DemoRestaurant demoRestaurant) {
        this.demoRestaurant = demoRestaurant;
    }
    @Override
    public void run() {
        try {
            while (true) {
                demoRestaurant.consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class b_BlockingQueue {
    public static void main(String[] args) {
        DemoRestaurant demoRestaurant = new DemoRestaurant();
        // 创建生产者和消费者线程
        for (int i = 0 ; i < 5 ; i++){
            new Thread(new Producer(demoRestaurant),"Producer No." + i).start();
        }
        for (int i = 0 ; i< 10 ; i++){
            new Thread(new Consumer(demoRestaurant),"Consumer No." + i).start();
        }
    }
}
