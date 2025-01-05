package a_basicMultiThreading;

import java.util.ArrayList;
import java.util.List;

class Resource2 {
    private int product = 0;
    private int max;
    private int min;
    private List<Integer> products;
    private final Object lock = new Object();

    public Resource2(int max, int min){
        this.max = max;
        this.min = min;
        this.products = new ArrayList<>();
    }

    public void produce() throws InterruptedException {
        synchronized(lock){
            while(true){
                if (products.size() == max){
                    System.out.println("Resource is ful, waiting to be consumed ... ");
                    lock.wait();
                }else{
                    products.add(product++);
                    System.out.println("Resource is not full, producing " + product);
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException{
        synchronized(lock){
            while(true){
                if (products.size() == min){
                    System.out.println("Resources is empty, waiting to be produced ... ");
                    lock.wait();
                }else{
                    System.out.println("Resources is not empty, consuming " + products.removeLast()+1);
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }
}

public class f2_ThreadCommunication {
    public static void main(String[] args) {
        Resource2 resources = new Resource2(10,0);
        Thread producer = new Thread(() -> {
            for (int i = 0 ; i < 3 ; i++){ // 3次生产线程
                try{
                    resources.produce();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0 ; i < 3 ; i++){ // 3次消费线程
                try{
                    resources.consume();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
