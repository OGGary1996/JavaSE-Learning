package b_threadPool;

// 本例子展示如何使用ThreadPoolExecutor的构造方法进行自定义线程池
// 在之前的例子中，有一些Java已经封装好的线程池类型，他们都使用Executors工具类中的静态方法创建；返回一个ExecutorService的实现类
// ExecutorService接口属于Executor接口的子接口，Executor接口是线程池的顶级接口

// 如果使用自定义线程池，则需要使用ThreadPoolExecutor类
// ThreadPoolExecutor类是ExecutorService接口的核心实现类

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DemoTask implements Runnable {
    private int ID;
    private static int count = 0;
    private final static Lock lock = new ReentrantLock();
    public DemoTask(int ID){
        this.ID = ID;
    }
    @Override
    public void run(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " is running task " + ID + ", current count is " + count);
            Thread.sleep(500);
            count++;
            System.out.println(Thread.currentThread().getName() + " is finished task " + ID + ", current count is " + count);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class f_customizeThreadPool {
    public static void main(String[] args) {
        // 通过自定义线程池的方式创建一个线程池
        ThreadPoolExecutor customizedPool = new ThreadPoolExecutor(
                4, // corePoolSize: 核心线程数
                10, // maximumPoolSize: 最大线程数 -> 临时线程数 = 10 - 4
                60, // keepAliveTime: 线程存活时间
                TimeUnit.SECONDS,// 时间单位
                new ArrayBlockingQueue<>(10), // workQueue: 任务队列,最大长度为3
                Executors.defaultThreadFactory(), // 默认线程工厂
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略: 直接抛出异常,默认策略
        );

        // 提交任务
        for (int i = 1 ; i <= 20 ; i++){
            customizedPool.submit(new DemoTask(i));
        }

        // 关闭线程池
        customizedPool.shutdown();
        try{
            if (!customizedPool.awaitTermination(20, TimeUnit.SECONDS)){
                customizedPool.shutdownNow();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            customizedPool.shutdownNow();
            Thread.currentThread().interrupt(); // 中断主线程
        }
    }
}
