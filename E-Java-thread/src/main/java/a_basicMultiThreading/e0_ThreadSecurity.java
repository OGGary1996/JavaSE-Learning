package a_basicMultiThreading;

class Counter implements Runnable{
    private static int count = 0; // static变量，所有实例共享，全局计数器，但是不影响线程安全与否
    private void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
    @Override
    public void run(){
        for (int i = 0 ; i < 1000 ; i++){
            increment();
        }
    }
}

class SynchronizedCounter implements Runnable{
    private static int count = 0;
    // 通过使用synchronized关键字来修饰方法，来实现线程安全
    // 实现原理：
        // 1. synchronized关键字会在方法调用时自动获取对象锁，确保同一时刻只有一个线程可以执行该方法。
        // 2. 当一个线程在执行synchronized方法时，其他线程必须等待，直到该线程完成执行并释放锁。
    private synchronized void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
    @Override
    public void run(){
        for (int i = 0 ; i < 1000 ; i++){
            increment();
        }
    }
}

public class e0_ThreadSecurity {
    public static void main(String[] args) throws InterruptedException {
        // example: 不使用synchronized关键字同步
        Thread task1 = new Thread(new Counter());
        Thread task2 = new Thread(new Counter());
        task1.start();
        task2.start();
        task1.join();
        task2.join();
        // 此时，全局计数器的值不一定是2000，因为两个线程是并发执行的，可能会出现线程安全问题
        System.out.println("Counter without synchronization: " + new Counter().getCount()); // 获取最后的全局计数器值

        // example2,使用synchronized关键字同步
        Thread task3 = new Thread(new SynchronizedCounter());
        Thread task4 = new Thread(new SynchronizedCounter());
        task3.start();
        task4.start();
        task3.join();
        task4.join();
        System.out.println("SynchronizedCounter with synchronization: " + new SynchronizedCounter().getCount()); // 获取最后的全局计数器值

    }
}
