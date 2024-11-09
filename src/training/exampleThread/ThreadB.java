package training.exampleThread;

public class ThreadB extends Thread {
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("ThreadB " + i);
            try{
                Thread.sleep(10); // 手动控制线程执行之后的间隔时间，单位是毫秒
            }catch(InterruptedException e){
                e.printStackTrace();
            };
        }
    }
}
