package c_Semaphore;

// 本例子通过在外部创建模拟的资源和runnable类 来模拟多线程对同一个资源的访问，并且通过Semaphore来控制同时访问资源的线程数量。

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Resources {
    private int num = 100;

    public int getNum(){
        return num;
    }
}

class Access implements Runnable {
    private Resources resource;
    private Semaphore semaphore;

    public Access(Resources resource, Semaphore semaphore){
        this.resource = resource;
        this.semaphore = semaphore;
    }

    public void run(){
        try{
            System.out.println(Thread.currentThread().getName() + "is acquiring the permit");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "has got the permit, resource is: " + resource.getNum());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " is releasing the permit");
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            semaphore.release();
        }
    }

}

public class a_Semaphore {
    public static void main(String[] args) {
        Resources resource = new Resources();
        Semaphore semaphore = new Semaphore(2);

        // 创建5个线程，但是一次性只能有两个线程获取permit
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0 ; i < 5 ; i++){
            executor.submit(new Access(resource,semaphore));
        }
        executor.shutdown();
        try{
            if(!executor.awaitTermination(60, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
