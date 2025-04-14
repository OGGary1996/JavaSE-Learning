package c_threadCollaboration;

import java.util.concurrent.CountDownLatch;

// 本案例演示如何使用CountDownLatch进行简单的3个线程的同步

public class a1_CountDownLatch {
    public static void main(String[] args) {
        // create a count latch
        CountDownLatch count = new CountDownLatch(3); // 3 is the count
        // create 3 threads
        Thread one = new Thread(() -> {
            System.out.println("Thread 1 is running ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1 is done!");
            count.countDown(); // decrement the count,when thread is done
        });
        Thread two = new Thread(() -> {
            System.out.println("Thread 2 is running ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 is done!");
            count.countDown(); // decrement the count,when thread is done
        });
        Thread three = new Thread(() -> {
            System.out.println("Thread 3 is running ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3 is done!");
            count.countDown(); // decrement the count,when thread is done
        });

        // start the threads
        one.start();
        two.start();
        three.start();

        try {
            count.await(); // wait until the count is 0
            System.out.println("All threads are done!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
