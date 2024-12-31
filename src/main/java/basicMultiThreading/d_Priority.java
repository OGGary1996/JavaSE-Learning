package basicMultiThreading;

public class d_Priority {
    public static void main(String[] args){
        Thread thread1 = new Thread(() -> {
            for(int i = 0 ; i < 10; i++){
                System.out.println("Thread 1 is running ...");
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0 ; i < 10; i++){
                System.out.println("Thread 2 is running ...");
            }
        });

        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();

        // 根据输出结果，不同的操作系统可能会有不同的表现，优先级知识提供给一个线程调度的建议，不是强制性的

    }
}
