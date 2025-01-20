package e_lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 本例子，我们将读写锁的定义放在了一个类中，这样可以更好的封装读写锁的使用

public class c1_ReadWriteLock {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private final List<Integer> nums = new ArrayList<>();

    public void read () {
        readLock.lock(); // 获取读锁
        try{
            System.out.println(Thread.currentThread().getName() + " is reading " + nums);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock.unlock(); // 释放读锁
        }
    }

    public void write (int num) {
        writeLock.lock(); // 获取写锁
        try{
            nums.add(num);
            System.out.println(Thread.currentThread().getName() + " is writing " + num);
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock(); // 释放写锁
        }
    }

    public static void main(String[] args) {
        c1_ReadWriteLock rw = new c1_ReadWriteLock();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            executor.submit(() -> rw.write(finalI)); // 创建2个写线程
        }
        for (int i = 0; i < 3; i++) {
            executor.submit(() -> rw.read()); // 创建3个读线程
        }
        executor.shutdown();
    }
}
