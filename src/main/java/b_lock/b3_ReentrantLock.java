package b_lock;

// 本例子使用lockInterruptibly()方法，实现了对锁的可中断获取，如果获取失败则抛出异常

import java.util.concurrent.locks.ReentrantLock;

public class b3_ReentrantLock {
    ReentrantLock lock = new ReentrantLock();

    public void accessResource(){
        try {
            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + " is required the lock to access the resource");
                Thread.sleep(5000);
            } finally {
                lock.unlock();
            }
        }catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " is interrupted.");
        }
    }

    public static void main(String[] args) {
        b3_ReentrantLock simulation = new b3_ReentrantLock();
        Thread t1 = new Thread(simulation::accessResource);
        Thread t2 = new Thread(simulation::accessResource);
        t1.start();
        t2.start();
        t2.interrupt();
    }
}
