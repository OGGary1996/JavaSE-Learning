package c_threadCollaboration;

// 本例子通过使用CyclicBarrier来模拟简单的3个线程之间的等待，结果等待之后调用barrierAction的操作
// 通过在每个线程中重复循环调用barrier.await()方法，可以实现多次等待

// CyclicBarrier是一个同步辅助类，允许一组线程互相等待，直到到达某个公共屏障点
// 如果需要操作的共享资源不是线程安全类的或者不是原子操作的类型，那么仍然还是需要使用Lock

import java.util.concurrent.*;
class Restaurant2{
    public CyclicBarrier cyclicBarrier;
    public Restaurant2(int parties, Runnable barrierAction) {
        if(barrierAction != null){
            this.cyclicBarrier = new CyclicBarrier(parties, barrierAction);
        }
    }
    // 生产方法
    public void produce() throws InterruptedException {
        System.out.println("Chef " + Thread.currentThread().getName() + " is cooking ...");
        Thread.sleep(1000);// 模拟烹饪时间
        System.out.println("Chef " + Thread.currentThread().getName() + " is done!");
    }
    // 上菜方法
    public void serve() throws InterruptedException {
        System.out.println("All chefs are done! Serving the food ...");
        Thread.sleep(500);
        System.out.println("Food is served!");
    }
}
// 厨师线程
class Chef2 implements Runnable{
    private final Restaurant2 restaurant;
    public Chef2(Restaurant2 restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run(){
        try {
            while (true) { // 通过循环来反复调用barrier.await()方法，在到达barrier之后，又重新执行生产操作
                restaurant.produce();
                restaurant.cyclicBarrier.await(); // 等待其他厨师线程
            }
        } catch (InterruptedException e) {
            System.out.println("Chef " + Thread.currentThread().getName() + " is interrupted!");
            e.printStackTrace();
        }catch (BrokenBarrierException e){
            System.out.println("Chef " + Thread.currentThread().getName() + " is broken barrier!");
            e.printStackTrace();
        }
    }
}
// 上菜线程,作为barrierAction
class Waiter2 implements Runnable{
    private final Restaurant2 restaurant;
    public Waiter2(Restaurant2 restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run(){
        try {
            restaurant.serve();
        }catch(InterruptedException e) {
            System.out.println("Waiter is interrupted!");
            e.printStackTrace();
        }
    }
}

public class b3_CyclicBarrier {
    public static void main(String[] args) {
        int parties = 10;// 共计10个厨师线程
        Restaurant2 restaurant = new Restaurant2(parties,null);
        Waiter2 waiter = new Waiter2(restaurant);
        restaurant.cyclicBarrier = new CyclicBarrier(parties,waiter);

        // 创建10个厨师线程
        for(int i = 0 ; i < parties ; i++){
            new Thread(new Chef2(restaurant)).start();
        }

    }

}
