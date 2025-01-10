package d_concurrentCollections;

import java.util.concurrent.CountDownLatch;

// 本案例演示如何使用CountDownLatch进行简单的3个线程的同步

class Restaurant implements Runnable {
    private String name;
    private String dish;
    private CountDownLatch count;

    public Restaurant(String name, String dish, CountDownLatch count){
        this.name = name;
        this.dish = dish;
        this.count = count;
    }

    @Override
    public void run(){
        try{
            System.out.println("Chef " + name + " is preparing " + dish + " ...");
            Thread.sleep(2000);
            System.out.println("Chef " + name + " has prepared " + dish + "!");
            count.countDown();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class d2_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // create a count latch
        int chefNumber = 3;
        CountDownLatch count = new CountDownLatch(chefNumber); // 3 is the count
        // create 3 threads
        new Thread(new Restaurant("John", "Pizza", count)).start();
        new Thread(new Restaurant("Doe", "Burger", count)).start();
        new Thread(new Restaurant("Jane", "Pasta", count)).start();

        count.await(); // wait until the count is 0
        System.out.println("All chefs are done!");
    }
}
