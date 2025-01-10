package d_concurrentCollections;

/*
    * 本例子通过使用Exchanger来实现两个线程之间的数据交换
    * 两个线程分别通过循环模拟生产和消费数据
 */

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class f2_Exchanger {
    public static void main(String[] args) {
        // create an Exchanger
        Exchanger<String> dataExchanger = new Exchanger<>();
        // create the producer thread and consumer thread
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            for (int i = 1 ; i <= 5 ; i++){
                try{
                    String product = "Product - " + i;
                    System.out.println("Producer has produced: " + product);
                    String feedback = dataExchanger.exchange(product);
                    System.out.println("Producer has received feedback: " + feedback);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        executor.submit(() -> {
            for (int i = 1 ; i <= 5 ; i++){
                try{
                    Thread.sleep(1000);
                    String feedback = "Feedback - " + i;
                    String product = dataExchanger.exchange(feedback);
                    System.out.println("Consumer has received product: " + product);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        // shut down the executor
        executor.shutdown();
    }
}
