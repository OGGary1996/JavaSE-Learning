package e_lock;

// 本例子通过使用tryLock方法，实现了对锁的尝试获取，如果获取成功则执行，否则执行其他代码

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class b2_ReentrantLock {
    ReentrantLock lock = new ReentrantLock();

    public void accessResource(){
        try{
            if (lock.tryLock(2, TimeUnit.SECONDS)){ // 尝试获取锁，最多等待两秒
                System.out.println(Thread.currentThread().getName() + " is required the lock to access the resource");
                Thread.sleep(3000);
            }else{
                System.out.println(Thread.currentThread().getName() + " cannot get the lock.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        b2_ReentrantLock simulation = new b2_ReentrantLock();
        new Thread(simulation::accessResource).start();
        new Thread(simulation::accessResource).start();
    }
}
