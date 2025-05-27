package a_basicMultiThreading;

public class d_JoinYieldThread {
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
        // 通过join方法，将thread1和thread2加入到主线程中，主线程会等待thread1和thread2执行完毕后再执行
        thread1.start(); // 启动线程1
        thread1.join(); // 主线程必须等待线程1执行完毕后才能继续执行

        thread2.start(); // 此时线程1已经执行完毕，主线程执行启动线程2
        thread2.join(); // 主线程再次等待线程2执行完毕后才能继续执行
        for(int i = 0; i < 10; i++){ // 主线程剩余的任务
            System.out.println("Main Thread: " + i);
        }

        // 使用yield()方法让当前线程让出CPU资源
        // 这个方法是静态方法，需要在当前线程中调用，或者是在任务的逻辑代码中调用
    }
}
