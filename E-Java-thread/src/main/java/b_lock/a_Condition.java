package b_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 类似与Synchronized中的线程通信wait,notify方法
// 在使用lock时，也有对应的线程通信方法

class Restaurant{
    private final int MAX_DISH = 5; // 最大dish数量
    private int dish = 0;
    // 创建锁，并且创建Condition对象
    private final Lock lock = new ReentrantLock(true); // 公平锁
    private final Condition notFull = lock.newCondition(); // 生产者线程的条件变量，表示一个没有生产满的情况；是一个状态。
    private final Condition notEmpty = lock.newCondition(); // 消费者的条件变量，表示没有消费完的情况。

    // 创建生产方法
    public void produce() throws InterruptedException {
        lock.lock();//获取锁
        try {
            // 判断是否达到最大dish数量
            while(dish >= MAX_DISH){ //如果达到上限，则notFull这个状况需要进入等待
                System.out.println("Reached Maximum Dish, Waiting for Consumption...");
                notFull.await();
            }
            // 如果此时还没达到最大dish数量，则进行生产操作，并且通知notEmpty状态准备唤醒
            Thread.sleep(1000);// 模拟生产时间,1秒
            dish++;
            System.out.println(Thread.currentThread().getName() + " has produced 1 dish, now have " + dish);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 创建消费方法
    public void consume() throws InterruptedException {
        lock.lock();
        try{
            while(dish == 0){ // 如果此时没有dish，则notEmpty这个状态需要进入等待
                System.out.println("Waiting for Dishes to be Produced...");
                notEmpty.await();
            }
            // 如果此时有dish，则进行消费操作，并且通知notFull状态准备唤醒
            Thread.sleep(1500);
            dish--;
            System.out.println(Thread.currentThread().getName() + " has consumed 1 dish, now rest: " + dish);
            notFull.signal();
        }finally {
            lock.unlock();
        }
    }
}

class Cook implements Runnable {
    private final Restaurant restaurant;

    public Cook(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        while (true) {
            try {
                restaurant.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

class Customer implements Runnable {
    private final Restaurant restaurant;

    public Customer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        while (true) {
            try {
                restaurant.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

public class a_Condition {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Thread cookThread1 = new Thread(new Cook(restaurant), "Cook1");
        Thread cookThread2 = new Thread(new Cook(restaurant), "Cook2");
        Thread customerThread1 = new Thread(new Customer(restaurant), "Customer1");
        Thread customerThread2 = new Thread(new Customer(restaurant), "Customer2");
        Thread customerThread3 = new Thread(new Customer(restaurant), "Customer3");
        // 启动线程
        cookThread1.start();
        cookThread2.start();
        customerThread1.start();
        customerThread2.start();
        customerThread3.start();
        // 等待线程结束
    }
}
