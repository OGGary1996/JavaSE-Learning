package training.tutorial;
// 之前的方法中，我们使用了extends Thread来创建线程，还有一种方法是实现Runnable接口。
// 由于使用了implements Runnable，我们无法再使用.start()方法，因为这个方法属于Thread类。
// 可以先创建一个Thread的实例，然后将Runnable的实例传递给Thread的constructor，然后再调用.start()方法。
import training.tutorial.exampleThread.ThreadC;
import training.tutorial.exampleThread.ThreadD;

public class w_Thread2_Runnable {
    public static void main(String[] args) {
        Runnable c = new ThreadC("ThreadC");
        Runnable d = new ThreadD("ThreadD");

        // 创建线程
        Thread t1 = new Thread(c); // 将ThreadC的实例传递给Thread的constructor，这个constructor可以接收一个Runnable的实例 
        Thread t2 = new Thread(d); // 将ThreadD的实例传递给Thread的constructor,这个constructor可以接收一个Runnable的实例
        
        t1.start(); // 启动线程
        t2.start(); // 启动线程
        System.out.println(t1.getPriority()); // 5
        System.out.println(t2.getPriority()); // 5


        // 通过Anonymous inner class & lambda表达式创建线程，也就是不用创建一个新的类，直接在main方法中创建线程
        Runnable e = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    System.out.println("Thread e " + i);
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        };
        Thread t3 = new Thread(e);
        t3.start();

        Runnable f = () -> {
            for (int i = 0; i <= 20; i++){
                System.out.println("Thread f " + e );
                try {
                    Thread.sleep(100);
                }catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
        };
        Thread t4 = new Thread(f);
        t4.start();
    }
}
