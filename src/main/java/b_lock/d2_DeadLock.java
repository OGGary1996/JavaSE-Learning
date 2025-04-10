package b_lock;

// 本例子采用tryLock()方法来避免死锁,当固定时间内没有获取到锁时，就会放弃获取锁，执行其他操作

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class d2_DeadLock {
    private ReentrantLock lock1 = new ReentrantLock();
    private ReentrantLock lock2 = new ReentrantLock();

    public void task1() throws InterruptedException {
        if (lock1.tryLock(2, TimeUnit.SECONDS)){
            try {
                System.out.println(Thread.currentThread().getName() + " has got lock1");
                Thread.sleep(1000);
                if (lock2.tryLock(2,TimeUnit.SECONDS)){
                    try{
                        System.out.println(Thread.currentThread().getName() + " has got lock2");
                    }finally {
                        lock2.unlock();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + " has not got lock2");
                }
            }
            finally {
                lock1.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName() + " has not got lock1");
        }
    }

    public void task2() throws InterruptedException{
        if (lock2.tryLock(2,TimeUnit.SECONDS)){
            try{
                System.out.println(Thread.currentThread().getName() + " has got lock2");
                Thread.sleep(1000);
                if (lock1.tryLock(2,TimeUnit.SECONDS)){
                    try{
                        System.out.println(Thread.currentThread().getName() + " has got lock1");
                    }finally{
                        lock1.unlock();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + " has not got lock1");
                }
            }finally {
                lock2.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName() + " has not got lock2");
        }
    }

    public static void main(String[] args) {
        d2_DeadLock simulation = new d2_DeadLock();
        new Thread(() -> {
            try{
                simulation.task1();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        },"Thread1").start();

        new Thread (() -> {
            try{
                simulation.task2();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        },"Thread2").start();
    }


}
