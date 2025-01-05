package a_basicMultiThreading;

// 创建线程的第一种方法：继承Thread类，或者直接创建Thread的匿名子类
class Thread1 extends Thread{
    @Override
    public void run(){
        for (int i = 0;i < 10;i++){
            System.out.println("Thread 1: " + i);
        }
    }
}

public class a_CreateThread {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();

            // 或者直接创建Thread的匿名子类,用匿名子类重写run方法，等同于传递了Runnable对象
        Thread thread2 = new Thread(){
            @Override
            public void run(){
                for (int i = 0;i < 10;i++){
                    System.out.println("Thread 2: " + i);
                }
            }
        };
        thread2.start();

        // 创建线程的第二种方法：实现Runnable接口，或者直接创建Runnable的匿名子类
        Thread thread3 = new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0;i < 10;i++){
                    System.out.println("Thread 3: " + i);
                }
            }
        });
        thread3.start();
            // 或者使用Lambda表达式
        Thread thread4 = new Thread(() -> {
            for (int i = 0;i < 10;i++){
                System.out.println("Thread 4: " + i);
            }
        });
        thread4.start();

        // 输出结果是混乱的，因为线程是并发执行的，由操作系统调度执行

    }
}