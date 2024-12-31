package basicMultiThreading;

public class b_JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0;i < 10;i++){
                System.out.println("Thread 1: " + i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0;i < 10;i++){
                System.out.println("Thread 2: " + i);
            }
        });

        // 此时线程还未开始执行，所以会先输出这句话
        System.out.println("Before start thread1 and thread2 ... ");
        // 将Thread1 和 Thread2加入到主线程中，结果是不可预测的,因为线程是并发执行的，由操作系统调度执行
             // 通过join方法，将thread1和thread2加入到主线程中，主线程会等待thread1和thread2执行完毕后再执行
        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();
        for(int i = 0; i < 10; i++){
            System.out.println("Main Thread: " + i);
        }

        // 通过join方法，将thread1和thread2加入到主线程中，主线程会等待thread1和thread2执行完毕后再执行
    }
}
