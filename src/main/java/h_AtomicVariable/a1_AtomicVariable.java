package h_AtomicVariable;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// 本例子通过多线程模拟多个线程对一个计数器进行累加操作，使用AtomicInteger中的incrementAndGet()方法来保证线程安全。

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment(){
        count.incrementAndGet(); //  count++;
    }
    public int getCount(){ // 注意本方法返回值不能是AtomicInteger, 因为AtomicInteger是对象，不能直接返回对象
        return count.get(); // 通过调用AtomicInteger的get()方法来获取值
    }
}

public class a1_AtomicVariable {
    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> result1 = executor.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
            return counter.getCount();
        });
        Future<Integer> result2 = executor.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
            return counter.getCount();
        });

        try{
            result1.get();
            result2.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            executor.shutdown();
        }

        System.out.println(counter.getCount()); // 2000


    }
}
