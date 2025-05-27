package i_AtomicVariable;

// 本例子通过多线程模拟多个线程对一个计数器进行累加操作，使用AtomicInteger中的compareAndSet()方法来保证线程安全。

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class counter2 {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment(){
        int currentCount = count.get();
        boolean success = count.compareAndSet(currentCount, currentCount + 1);
        if (success){
            System.out.println(Thread.currentThread().getName() + " has incremented the count");
        }else{
            System.out.println(Thread.currentThread().getName() + " failed to increment the count");
        }
    }

    public int getCount(){
        return count.get();
    }
}
public class a2_AtomicVariable {
    public static void main(String[] args) {
        counter2 counter = new counter2();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> result1 = executor.submit(() -> {
            for (int i = 0 ; i < 5 ; i++){
                counter.increment();
            }
            return counter.getCount();
        });

        Future<Integer> result2 = executor.submit(() -> {
            for (int i = 0 ; i < 5 ; i++){
                counter.increment();
            }
            return counter.getCount();
        });

        try {
            result1.get();
            result2.get();
        }catch(ExecutionException | InterruptedException e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

        System.out.println("Result : " + counter.getCount());
    }
}
