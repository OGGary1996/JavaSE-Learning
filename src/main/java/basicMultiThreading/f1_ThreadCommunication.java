package basicMultiThreading;

class Resource1 {
    private int value = 0;
    private boolean produced = false;

    public synchronized void produce() throws InterruptedException {
        while(produced){ // 表示已经生产，需要等待消费
            wait(); // 若已经生产，wait会解锁当前对象锁，让其他线程可以获取锁
        }
        value++; // 模拟生产过程
        System.out.println("Produced: " + value);
        produced = true; // 生产完成
        notify(); // 通知消费,唤醒调用消费的线程
    }
    public synchronized void consume() throws InterruptedException{
        while(!produced){ // 表示还未生产，需要进入等待
            wait(); // 若还未生产，wait会解锁当前对象锁，让其他线程可以获取锁
        }
        System.out.println("Consumed: " + value);
        produced = false; // 消费完成
        notify(); // 通知生产，唤醒调用生产的线程
    }
}

public class f1_ThreadCommunication {
    public static void main(String[] args) {
        Resource1 resource = new Resource1();
        Thread threadProduce = new Thread(() -> {
            try{
                for (int i = 0 ; i < 10 ; i++){
                    resource.produce();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread threadConsume = new Thread(() -> {
            try{
                for (int i = 0; i < 10 ; i++){
                    resource.consume();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        threadProduce.start();
        threadConsume.start();

    }
}
