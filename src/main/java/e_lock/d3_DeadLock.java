package e_lock;

// 本例子采用Java内置的ThreadMXBean 工具类来检测死锁。

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.ReentrantLock;

public class d3_DeadLock {
    private ReentrantLock lock1 = new ReentrantLock();
    private ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        // 创建线程
        d3_DeadLock simulation = new d3_DeadLock();
        new Thread(simulation::task1,"Thread1").start();
        new Thread(simulation::task2,"Thread2").start();

        // 创建检测死锁的线程
        Thread monitor = new Thread(() -> {
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            while(true){ // 持续监测
                long[] deadLockThreads = threadMXBean.findDeadlockedThreads();
                if (deadLockThreads != null){
                    System.out.println("DeadLock Detected!");
                    for (long deadLockThread : deadLockThreads){
                        System.out.println("Thread in deadlock: " + threadMXBean.getThreadInfo(deadLockThread));
                    }
                    break;
                }
                try{
                    Thread.sleep(5000); // 每间隔1秒检测一次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        monitor.setDaemon(true);
        monitor.start();
    }

    // 创建线程的任务
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
}
