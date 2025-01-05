package a_basicMultiThreading;

class Counter3{
    private int count1 = 0;
    private int count2 = 0;
    // 针对不同的方法，使用不同的锁，两个线程互不干扰，并发执行
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void incrementCount1(){
        synchronized(lock1){
            count1++;
        }
        System.out.println(Thread.currentThread().getName() + " --- " + count1);
    }
    public void incrementCount2(){
        synchronized(lock2){
            count2++;
        }
        System.out.println(Thread.currentThread().getName() + " --- " + count2);
    }
}

public class e3_synchronizedBlock {
    public static void main(String[] args) {
        Counter3 counter = new Counter3();
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

        // 输出结果为两个线程并发执行，count1和count2互不干扰，因为使用了不同的锁
    }
}
