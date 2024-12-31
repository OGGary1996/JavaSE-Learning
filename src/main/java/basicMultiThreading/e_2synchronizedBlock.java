package basicMultiThreading;

class Counter2 {
    private int count1 = 0;
    private int count2 = 0;
    // 针对不同的方法使用同样的锁，两个线程互斥
    // 这种情况下，只有一个线程能持有锁，另一个线程等待锁释放，即使它们访问不同的计数器 count1 和 count2，它们也不能并发执行。
    private final Object lock = new Object();
    public void incrementCount1(){
        synchronized (lock){ // 使用this锁定，锁定的是整个Counter2对象
            count1++;
            System.out.println(Thread.currentThread().getName() + " --- " + count1);
        }
    }
    public void incrementCount2(){
        synchronized (lock){
            count2++;
            System.out.println(Thread.currentThread().getName() + " --- " + count2);
        }
    }
}

public class e_2synchronizedBlock {
    public static void main(String[] args) {
        Counter2 counter = new Counter2();
        Thread thread1 = new Thread(() -> {
            for (int i = 0 ; i < 100 ; i++){
                counter.incrementCount1();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0 ; i < 100 ; i++){
                counter.incrementCount2();
            }
        });
        thread1.start();
        thread2.start();

        // 输出结果为2000，因为count++被锁定，但是打印并为锁定，还是并发执行
    }
}
