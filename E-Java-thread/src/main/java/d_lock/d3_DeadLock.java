package d_lock;

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
        // 通过ManagementFactory中的静态方法获取到ThreadMXBean实例
        Thread deadLockDetector = new Thread(() -> {
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            // 获取死锁线程ID,通过循环来进行获取
            while(true){
                // 创建long类型的数组，存醋死锁线程ID(long类型)
                long[] deadlockedThreadIDs = threadMXBean.findDeadlockedThreads();
                if (deadlockedThreadIDs != null){ // 非空且非null
                    for( long deadlockedThreadID : deadlockedThreadIDs){
                        // 获取死锁线程的名称
                        String threadName = threadMXBean.getThreadInfo(deadlockedThreadID).getThreadName();
                        System.out.println("Deadlock detected in thread: " + threadName);
                    }
                }
                // 休眠5秒钟
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // 设置为守护线程并启动
        deadLockDetector.setDaemon(true);
        deadLockDetector.start();

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
