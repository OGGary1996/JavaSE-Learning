package a_basicMultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 创建线程的第一种方法：继承Thread类
class DemoThread extends Thread{
    @Override
    public void run(){
        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName()+ i);
        }
    }
}

// 创建线程的第二种方法：实现Runnable接口
class DemoThread2 implements Runnable{
    @Override
    public void run(){
        for (int i = 0;i < 10;i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

// 创建线程的第三种方法：实现Callable接口，并使用Future接受返回值
class DemoThread3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0;i < 100;i++){
            System.out.println(Thread.currentThread().getName()+ i);
        }
        return 1;
    }
}

public class a1_CreateThread {
    public static void main(String[] args) {
        // 创建线程的第一种方法：继承Thread类
            // 直接创建DemoThread1的实例，并且调用start方法
        Thread thread1 = new DemoThread();
        thread1.start();
            // 直接创建Thread的匿名子类，并且调用start方法，缺点是不能重复使用
        Thread thread2 = new Thread(){
            @Override
            public void run(){
                for (int i = 0;i < 10;i++){
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        };
        thread2.start();

        // 创建线程的第二种方法：实现Runnable接口
            // 直接创建DemoThread2的实例,传递给Thread的构造方法构建Thread的实例，并且调用start方法
        Thread thread3 = new Thread(new DemoThread2());
        thread3.start();
            // 直接创建Runnable的实现类，并传递给Thread的构造函数，缺点是不能重复使用
        Thread thread4 = new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0;i < 10;i++){
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        });
        thread4.start();
            // 使用Lambda表达式创建Runnable的实现类，并传递给Thread的构造函数
        Thread thread5 = new Thread(() -> {
            for (int i = 0;i < 10;i++){
                System.out.println(Thread.currentThread().getName()+ i);
            }
        });
        thread5.start();

        // 创建线程的第三种方法：实现Callable接口，并使用Future管理线程执行的结果
        // 而Future是接口，我们只能创建Future的实现类FutureTask的实例
            // 创建Callable的实现类的对象，并使用FutureTask包装线程，并且发送给Thread的构造函数构建Thread
        FutureTask<Integer> futureTask = new FutureTask<>(new DemoThread3());
        Thread thread6 = new Thread(futureTask);
        thread6.start();
        try {
            Integer result = futureTask.get(); // 阻塞获取结果
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

            // 直接创建Callable的匿名实现类
        FutureTask<Integer> futureTask2 = new FutureTask<>(()->{
            for (int i = 0;i < 10;i++){
                System.out.println("Thread 6: " + i);
            }
            return 1;
        });

    }
}