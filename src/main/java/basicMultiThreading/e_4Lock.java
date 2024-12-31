package basicMultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter4 {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    public void incrementCount(){
        lock.lock();
        try{
            count++;
        }finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + " --- " + count);
    }
}

public class e_4Lock {
    public static void main(String[] args) {
        Counter4 counter = new Counter4();
        Thread thread1 = new Thread(() -> {
            for (int i = 0 ; i < 100 ; i++){
                counter.incrementCount();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0 ; i < 100 ; i++){
                counter.incrementCount();
            }
        });
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        // 输出结果为200，因为count++被锁定，但是打印并为锁定，还是并发执行
    }
}
