package b_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 本例子在外部定义了一个simulation类，用于模拟生产者消费者的生产和消费过程
 * 生产和消费runnable接口位于外部，通过构造函数传入simulation类的实例
 */

public class a1_Condition {
    public static void main(String[] args) {
        simulation sim = new simulation();
        sim.simulation10Sec();
    }
}

class simulation {
    private final Lock lock;
    private final Condition bufferFull;
    private final Condition bufferEmpty;
    private final int bufferCapacity;
    private int count = 0;

    public simulation() {
        this.lock = new ReentrantLock();
        this.bufferFull = lock.newCondition();
        this.bufferEmpty = lock.newCondition();
        this.bufferCapacity = 10;
    }

    public void simulation10Sec() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new Producer(lock, bufferFull, bufferEmpty, bufferCapacity, this));
        executor.submit(new Consumer(lock, bufferFull, bufferEmpty, bufferCapacity, this));
        executor.shutdown();
        try{
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public void decrementCount() {
        count--;
    }
}

class Producer implements Runnable {
    private final Lock lock;
    private final Condition bufferFull;
    private final Condition bufferEmpty;
    private final int bufferCapacity;
    private final simulation sim;

    public Producer(Lock lock, Condition bufferFull, Condition bufferEmpty, int bufferCapacity, simulation sim) {
        this.lock = lock;
        this.bufferFull = bufferFull;
        this.bufferEmpty = bufferEmpty;
        this.bufferCapacity = bufferCapacity;
        this.sim = sim;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (sim.getCount() == bufferCapacity) {
                    System.out.println("Producer is waiting, buffer is full...");
                    bufferFull.await();
                }
                sim.incrementCount();
                System.out.println("Produced Count: " + sim.getCount());
                bufferEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final Lock lock;
    private final Condition bufferFull;
    private final Condition bufferEmpty;
    private final int bufferCapacity;
    private final simulation sim;

    public Consumer(Lock lock, Condition bufferFull, Condition bufferEmpty, int bufferCapacity, simulation sim) {
        this.lock = lock;
        this.bufferFull = bufferFull;
        this.bufferEmpty = bufferEmpty;
        this.bufferCapacity = bufferCapacity;
        this.sim = sim;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (sim.getCount() == 0) {
                    System.out.println("Consumer is waiting, buffer is empty...");
                    bufferEmpty.await();
                }
                System.out.println("Consumed Count: " + sim.getCount());
                sim.decrementCount();
                bufferFull.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}