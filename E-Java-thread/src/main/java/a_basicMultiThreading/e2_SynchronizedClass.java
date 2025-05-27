package a_basicMultiThreading;

// 本例子演示Synchronized关键字的第二种用法
// 同步属于类的静态方法或者代码块，由于是同步类的方法，所以方法或者代码块必须是静态的


class SynchronizedResources2{
    private static int counter = 0;
    // 同步当前类的静态方法或者代码块有两种写法
    // 1. synchronized修饰静态方法
//    private static synchronized void increment(){
//        counter++;
//    }
    // 2. synchronized修饰静态代码块
    public void increment(){
        synchronized(SynchronizedResources2.class){
            counter++;
        }
    }
    public int getCounter() {
        return counter;
    }
}

class Task2 implements Runnable{
    private SynchronizedResources2 resources;
    public Task2(SynchronizedResources2 resources){
        this.resources = resources;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            resources.increment();
        }
    }
}

public class e2_SynchronizedClass {
    public static void main(String[] args) throws InterruptedException {
        // 由于使用的是同步类的方式，所以可以传递不同的对象
        Thread task1 = new Thread(new Task2(new SynchronizedResources2()));
        Thread task2 = new Thread(new Task2(new SynchronizedResources2()));
        // 启动线程
        task1.start();
        task2.start();
        task1.join();
        task2.join();
        System.out.println("Final counter value: " + new SynchronizedResources2().getCounter());
    }
}
