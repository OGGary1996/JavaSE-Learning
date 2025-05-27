package a_basicMultiThreading;

// 本例子演示Synchronized关键字的第三种用法
// 针对不同的对象锁进行同步，只有当线程需求同一个对象锁时才会互斥

class SynchronizedResources3{
    private static int counter = 0;
    // 创建锁对象
    // 如果锁对象没有使用static关键字，则每个实例都会有一个锁对象，如果此时传递多个对象给线程，则会导致锁对象不同，互不影响
    private static final Object incrementLock = new Object();
    public void increment(){
        synchronized(incrementLock){
            counter++;
        }
    }
    public int getCounter() {
        return counter;
    }
}

class Task3 implements Runnable{
    private SynchronizedResources3 resources;
    public Task3(SynchronizedResources3 resources){
        this.resources = resources;
    }

    @Override
    public void run(){
        for (int i = 0 ; i < 10000 ; i++){
            resources.increment();
        }
    }
}

public class e3_SynchronizedLock {
    public static void main(String[] args) throws InterruptedException {
        // 创建多线程,即使传递多个对象，他们都受到同一个锁的限制
        Thread task1 = new Thread(new Task3(new SynchronizedResources3()));
        Thread task2 = new Thread(new Task3(new SynchronizedResources3()));
        // 启动线程
        task1.start();
        task2.start();
        task1.join();
        task2.join();
        System.out.println("Final counter value: " + new SynchronizedResources3().getCounter());

    }
}
