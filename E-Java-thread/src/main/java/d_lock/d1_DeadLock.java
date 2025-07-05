package d_lock;

// 本例子采用两个线程互相获取对方的锁，导致死锁

import java.util.concurrent.locks.ReentrantLock;

public class d1_DeadLock {
    private ReentrantLock lock1 = new ReentrantLock();
    private ReentrantLock lock2 = new ReentrantLock();

    public void task1(){
        lock1.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " has got lock1");
            lock2.lock();
            try{
                System.out.println(Thread.currentThread().getName() + " has got lock2");
            }finally {
                lock2.unlock();
            }
        }finally{
            lock1.unlock();
        }
    }

    public void task2(){
        lock2.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " has got lock2");
            lock1.lock();
            try{
                System.out.println(Thread.currentThread().getName() + " has got lock1");
            }finally {
                lock1.unlock();
            }
        }finally{
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        d1_DeadLock simulation = new d1_DeadLock();
        new Thread(simulation::task1,"Thread1").start();
        new Thread(simulation::task2,"Thread2").start();
    }
    // 两个线程互相索取对方的锁，导致死锁，因为两个线程都在等待对方释放锁

}
