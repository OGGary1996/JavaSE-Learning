package h_Semaphore;

//在上一个例子中，我们通过Semaphore来控制了同时访问资源的线程数量，但是线程获取的permit是随机的，也就是说，线程获取permit的顺序是不确定的。
//如果我们希望线程获取permit的顺序是按照线程的创建顺序来的，那么我们可以使用FairSemaphore。


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class a2_Semaphore {
    public static void main(String[] args) {
        int num = 100;
        Semaphore semaphore = new Semaphore(2,true);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0 ; i < 5 ; i++){
            executor.submit(() -> {
                try{
                    System.out.println(Thread.currentThread().getName() + " is acquiring the permit");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " has got the permit, num is: " + num);
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is releasing the permit");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    semaphore.release();
                }
            });
        }
        executor.shutdown();
        try{
            if(!executor.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
