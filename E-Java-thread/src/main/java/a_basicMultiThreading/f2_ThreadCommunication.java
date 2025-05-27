package a_basicMultiThreading;
// 本例子将restaurant作为例子，cook线程作为生产者，customer线程作为消费者
// 生产者和消费者之间的通信使用wait和notify方法实现
// 最大dish数量为5，超过5个dish则生产者线程进入等待状态

// 弊端：
    // 由于wait,notify是基于同一个锁的环境，并且wait和notify只能广播形式的唤醒线程，不能做到精确唤醒
    // 无法精确调度线程的执行，比如只能等待dish被消费完毕才能生产，或者只能等待dish被生产完毕才能消费
class Restaurant {
    private final int MAX_DISH = 5; // 最大dish数量
    private int dish = 0;

    // 创建生产方法
    public synchronized void produce() throws InterruptedException {
        // 首先进行判断，是否达到最大dish数量
        while(dish == MAX_DISH) { //如果达到了，则进入等待状态释放锁；
            System.out.println("Waiting for dishes to be consumed...");
            wait();
        }
        // 如果没有达到，则进行生产操作，生产操作是一个循环且是一个耗时操作
        Thread.sleep(1000);// 模拟生产时间,1秒
        dish++; // 生产一个dish，并且通知消费者线程
        System.out.println(Thread.currentThread().getName() + " has produced dish: " + dish);
        // 生产完毕之后使用notify方法唤醒等待的消费者。
        notifyAll();
    }

    // 创建消费方法
    public synchronized void consume() throws InterruptedException {
        // 首先进行判断，是否有dish可以消费
        while(dish == 0) { // 如果没有dish，则进入等待状态释放锁；
            System.out.println("Waiting for dishes to be produced...");
            wait();
        }
        // 如果有dish，则进行消费操作，消费操作是一个循环且是一个耗时操作
        Thread.sleep(2000);// 模拟消费时间,2秒
        dish--; // 消费一个dish，并且通知生产者线程
        System.out.println(Thread.currentThread().getName() + " has consumed dish: " + dish);
        // 消费完毕之后使用notify方法唤醒等待的生产者。
        notifyAll();
    }
}

// 创建模拟任务逻辑代码
class Customer implements Runnable {
    private final Restaurant restaurant;
    public Customer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        while(true){ // 持续消费
            try {
                restaurant.consume();
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}

class Cook implements Runnable {
    private final Restaurant restaurant;
    public Cook(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        while(true){ // 持续生产
            try {
                restaurant.produce();
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}

public class f2_ThreadCommunication {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Thread cookThread1 = new Thread(new Cook(restaurant), "Cook1");
        Thread cookThread2 = new Thread(new Cook(restaurant), "Cook2");
        Thread customerThread1 = new Thread(new Customer(restaurant), "Customer1");
        Thread customerThread2 = new Thread(new Customer(restaurant), "Customer2");
        Thread customerThread3 = new Thread(new Customer(restaurant), "Customer3");
        // 启动线程
        cookThread1.start();
        cookThread2.start();
        customerThread1.start();
        customerThread2.start();
        customerThread3.start();
        // 等待线程结束
    }
}
