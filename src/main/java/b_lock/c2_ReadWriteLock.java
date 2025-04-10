package b_lock;

// 本例子使用两个class，一个是读写锁的定义，一个是模拟读写锁的使用

import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteLockDemo {
    private int count = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try{
            count++;
            System.out.println(Thread.currentThread().getName() + " is incrementing " + count);
        }finally {
            writeLock.unlock();
        }
    }

    public void getValue(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " is getting value " + count);
        }finally {
            readLock.unlock();
        }
    }
}

public class c2_ReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo simulation = new ReadWriteLockDemo();
        // 创建10个读线程
        for (int i = 0 ; i < 2 ; i++){
            new Thread(() -> {
                for(int j = 0 ; j < 3 ; j++){
                    simulation.getValue();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // 创建2个写线程
        new Thread(() -> {
            simulation.increment();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
