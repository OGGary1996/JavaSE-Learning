package basicMultiThreading;

public class c_DaemonUserThread {
    public static void main(String[] args){
        // create a Daemon thread
        Thread bgThread = new Thread(() -> {
            System.out.println("Daemon Thread is running ... ");
            int counter = 0;
            while(counter < 5000){
                try{
                    Thread.sleep(1000); // sleep for 1 second, 5000 seconds totally
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                counter++;
            }
        });

        bgThread.setDaemon(true); // set the thread as a Daemon thread

        // create a User thread
        Thread userThread = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                try{
                    Thread.sleep(1000); // sleep for 1 second, 10 seconds totally
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("User Thread is running ... ");
            }
            System.out.println("User Thread is done .");
        });

        bgThread.start();
        userThread.start();
        // 根据输出结果，不论Daemon线程是否执行完毕，只要User线程执行完毕，JVM就会退出,Daemon thread is terminated
    }
}
