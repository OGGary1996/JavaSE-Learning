package b_lock;

// 本例子体现了ReentrantLock的重入性，通过在一个线程的方法内部调用另外一个方法，实现了对同一个锁的重复获取

import java.util.concurrent.locks.ReentrantLock;

public class b1_ReentrantLock {
    ReentrantLock lock = new ReentrantLock();
    private int count = 0;
    public void outer(){
        lock.lock();
        try{
            count++;
            System.out.println(count);
            inner();
        }finally {
            lock.unlock();
        }
    }

    public void inner(){
        lock.lock();
        try{
            count--;
            System.out.println(count);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        b1_ReentrantLock simulation = new b1_ReentrantLock();
        new Thread(() -> {
            for (int i = 0 ; i < 10 ; i++){
                simulation.outer();
            }
        }).start();
    }
}
