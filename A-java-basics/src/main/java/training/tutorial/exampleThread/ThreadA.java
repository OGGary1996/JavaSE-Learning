package training.tutorial.exampleThread;
// Thread是一个类，我们可以继承Thread类，然后重写run方法，run方法中的代码会在线程启动时执行

public class ThreadA extends Thread { // 1. extends Thread
    public void run() { // 2. override run method, this method will be executed when thread is started
        for (int i = 0; i <= 20 ; i++){
            System.out.println("ThreadA " + i);
            try{
                Thread.sleep(10); // 手动控制线程执行之后的间隔时间，单位是毫秒
            }catch (InterruptedException e){
                e.printStackTrace();
            };
        }
    }
}
