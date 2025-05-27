package a_basicMultiThreading;

// 本例子演示在使用Synchronized关键字时，线程间的通信

class SharedResource {
    private int resource = 0; // 本例子使用resources模拟资源个数，不涉及到多个对象的操作，所以不需要使用static
    private boolean hasResource = false; // 初始状态下没有资源

    // 创建生产者方法
    public synchronized void produce() throws InterruptedException {
        // 先进行判断是否有资源,如果有资源则使用wait方法解锁
        while(hasResource) {
            wait(); // 解锁，等待消费者消费资源，生产者线程进入睡眠，不执行后续的代码
        }
        // 没有资源，生产者进行生产操作
        Thread.sleep(1000); // 模拟生产时间,1秒
        resource++;
        hasResource = true;
        System.out.println("Producer has produced resource: " + resource);
        // 生产完毕之后使用notify方法唤醒等待的消费者。
        notify();
        // 注意，notify方法并不会释放锁，只会唤醒一个等待的线程，此时生产者线程仍然持有锁
        // 在notify之后，生产者线程会继续执行，回到开始的while循环，判断是否有资源，此时才会真正的释放锁
    }

    // 创建消费者方法
    public synchronized void consume() throws InterruptedException {
        // 先进行判断是否有资源,如果没有资源则使用wait方法解锁
        while(!hasResource) {
            wait(); // 如果没有资源，消费者线程进入睡眠，不执行后续的代码
        }
        // 如果有资源，消费者进行消费操作
        Thread.sleep(1000);// 模拟消费时间,1秒
        resource--;
        hasResource = false;
        System.out.println("Consumer has consumed resource: " + resource);
        // 消费完毕之后使用notify方法唤醒等待的生产者。
        notify();
    }
}

// 创建模拟任务逻辑代码
class Simulator implements Runnable {
    private SharedResource sharedResource;
    public Simulator(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        while(true) { // 无限循环执行
            try {
                if (Thread.currentThread().getName().equals("Producer")){
                    sharedResource.consume();
                }else if (Thread.currentThread().getName().equals("Consumer")){
                    sharedResource.produce();
                }else{
                    System.err.println("Thread Name Error!");
                    break;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class f1_ThreadCommunication {
    public static void main(String[] args) {
        // 创建共享资源对象
        SharedResource sharedResource = new SharedResource();
        Simulator thread1 = new Simulator(sharedResource);
        Simulator thread2 = new Simulator(sharedResource);
        Thread producer = new Thread(thread1, "Producer");
        Thread consumer = new Thread(thread2, "Consumer");
        // 启动线程
        producer.start();
        consumer.start();
        // 等待线程结束
    }
}
