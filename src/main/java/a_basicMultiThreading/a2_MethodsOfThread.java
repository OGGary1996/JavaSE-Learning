package a_basicMultiThreading;

public class a2_MethodsOfThread {
    public static void main(String[] args) throws InterruptedException {
        // Thread类常用的成员方法
        // 1. 启动类，任务类
        Thread task1 = new Thread(() -> {
            for (int i = 0 ; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        task1.start();

        // 2. 控制调度类
        // sleep() - 静态方法，在线程任务中使用,join(),yield()
        task1.yield();
        Thread task2 = new Thread(() -> {
            for (int i = 0 ; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(1000);// 休眠1秒
                }catch (InterruptedException e){
                    System.out.println("Thread interrupted");
                    e.printStackTrace();
                }
            }
        });
        task2.start();
        task2.join();

        // 3. 检查线程的状态
        // isAlive() - 检查线程是否存活，isInterrupted() - 检查线程是否被中断

        // 4. 中断线程
        // interrupt() - 中断线程

        // 5. 获取线程的信息
        // get/setName() - 获取/设置线程的名称，get/setPriority() - 获取/设置线程的优先级
    }
}
