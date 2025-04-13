package b_lock;

// 本例子模拟多个线程争取对同一个Printer的访问，并且调用其中的print方法
// 采用ReentrantLock来实现线程的互斥访问

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Printer {
    private final ReentrantLock lock = new ReentrantLock(true);//采用公平锁

    // 主方法，打印
    public void printDoc() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is trying to get access to the printer.");
        // 获取锁
        if (lock.tryLock(2, TimeUnit.SECONDS)) { // 尝试获取锁，最多等待2秒
            // 获取锁之后执行操作：
            try {
                System.out.println(Thread.currentThread().getName() + " got access to the printer, " +
                        "hold count: " + lock.getHoldCount());
                System.out.println(Thread.currentThread().getName() + " is printing...");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " finished printing");
            }finally { // 释放锁
                System.out.println(Thread.currentThread().getName() + " is releasing the printer, " +
                        "hold count: " + lock.getHoldCount());
                lock.unlock();
                System.out.println("Lock releaser? -> " + lock.isLocked());
            }
        }else{ // 如果获取锁失败
            System.out.println(Thread.currentThread().getName() + " failed to get access to the printer.");
        }
    }
}

// 线程类
class printTask implements Runnable {
    private Printer printer;
    public printTask(Printer printer) {
        this.printer = printer;
    }
    @Override
    public void run(){
        while(true) {
            try{
                printer.printDoc();
            }catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
                break;
            }
        }
    }
}

public class b_ReentrantLock {
    public static void main(String[] args) {
        // 创建Printer对象
        Printer printer = new Printer();
        // 创建线程
        Thread thread1 = new Thread(new printTask(printer));
        Thread thread2 = new Thread(new printTask(printer));
        Thread thread3 = new Thread(new printTask(printer));
        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
        // 等待线程结束
    }

}
