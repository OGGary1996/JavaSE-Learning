package b_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 本例子演示了锁的基本使用，体现了锁的基本概念
class SynchronizedResources4 {
    // 由于线程中可能涉及到多个对象的操作，所以此处使用static修饰
    private static int count = 0;
    private static final Lock incrementLock = new ReentrantLock(); // 创建锁对象,此处创建可重入锁
    public void increment(){
        try {
            incrementLock.lock();
            count++;
        }finally {
            incrementLock.unlock();
        }
    }
    public int getCount(){
        return count;
    }
    public void print(){
        System.out.println("count = " + count);
    }
}

class IncrementThread implements Runnable{
    private SynchronizedResources4 resources;
    public IncrementThread(SynchronizedResources4 resources){
        this.resources = resources;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            resources.increment();
            if (i % 1000 == 0){ // 每1000次打印一次，检查结果
                resources.print();
            }
        }
    }
}

public class a0_Lock {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread task1 = new Thread(new IncrementThread(new SynchronizedResources4()));
        Thread task2 = new Thread(new IncrementThread(new SynchronizedResources4()));
        // 启动线程
        task1.start();
        task2.start();
        // 等待线程结束
        task1.join();
        task2.join();
        System.out.println("Final count = " + new SynchronizedResources4().getCount());

        // 最终结果是20000；但是每间隔1000次打印一次，可能会出现count不等于20000的情况；因为print方法没有加锁
    }
}
