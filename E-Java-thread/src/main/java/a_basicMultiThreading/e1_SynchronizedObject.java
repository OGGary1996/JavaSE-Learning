package a_basicMultiThreading;

// 本例子演示Synchronized关键字的第一种用法
// 用于同步当前的对象,想要实现线程安全的操作，必须保证传递的是同一个对象。

class SynchronizedResources1 {
    private int counter = 0; // 只创建了一个对象，所以不需要加上static
    // 同步当前对象的方法或者代码块，有两种方式
    // 1. synchronized修饰实例方法
//    public synchronized void increment(){
//        counter++;
//    }
    // 2. synchronized修饰代码块
    public void increment(){
        synchronized(this){
            counter++;
        }
    }
    public int getCounter() {
        return counter;
    }
}



public class e1_SynchronizedObject {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个共享资源,由于使用的是同步对象的方式，所以必须保证传递的是同一个对象
        SynchronizedResources1 sharedResources = new SynchronizedResources1();
        // 创建多线程
        Thread task1 = new Thread(() -> {
            for (int i = 0 ; i < 10000 ; i++){
                sharedResources.increment();
            }
        });
        Thread task2 = new Thread(() -> {
            for (int i = 0 ; i < 10000 ; i++){
                sharedResources.increment();
            }
        });
        // 启动线程
        task1.start();
        task2.start();
        task1.join();
        task2.join();
        System.out.println("Final counter value: " + sharedResources.getCounter());
    }
}
