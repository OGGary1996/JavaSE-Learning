package e_threadCollaboration;

import java.util.concurrent.CountDownLatch;

// 本案例演示如何使用CountDownLatch进行简单的多个线程的等待
// CountDownLatch是一个同步辅助类，允许一个或多个线程等待直到在其他线程中执行的一组操作完成
// 如果需要操作的共享资源不是线程安全类的或者不是原子操作的类型，那么仍然还是需要使用Lock

// 模拟餐厅经营，多个厨师线程进行生产操作，在所有的厨师线程完成之后，再进行上菜操作
class Restaurant{
    public final CountDownLatch countDown = new CountDownLatch(10); // 10 is the count

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
class Chef implements Runnable{
    private final Restaurant restaurant;
    public Chef(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    @Override
    public void run(){
        try {
            restaurant.produce();
        }catch (InterruptedException e){
            System.out.println("Chef " + Thread.currentThread().getName() + " is interrupted!");
        }finally { // 无论是否发生异常，厨师线程都要执行countDown操作
            restaurant.countDown.countDown();
        }
    }
}
// 上菜线程
class Waiter implements Runnable{
    private final Restaurant restaurant;
    public Waiter(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    @Override
    public void run(){
        try {
            // 等待所有厨师线程完成
            restaurant.countDown.await();
            restaurant.serve();
        }catch (InterruptedException e){
            System.out.println("Waiter is interrupted!");
        }
    }
}

public class a2_CountDownLatch {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        // 创建上菜线程
        new Thread(new Waiter(restaurant)).start();
        // 创建10个厨师线程
        for(int i = 0 ; i < 10 ; i++){
            new Thread(new Chef(restaurant)).start();
        }
    }
}
