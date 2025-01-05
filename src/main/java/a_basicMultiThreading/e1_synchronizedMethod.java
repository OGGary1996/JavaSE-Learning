package a_basicMultiThreading;

class Counter {
    private int count1 = 0;
    private int count2 = 0;

    public void incrementCount1(){
        count1++;
    }
    // 使用synchronized关键字，修改为同步方法
    public synchronized void incrementCount2(){
        count2++;
    }
    public int getCount1(){
        return count1;
    }
    public int getCount2(){
        return count2;
    }
}

public class e1_synchronizedMethod {
    public static void main(String[] args) {
        Counter counter = new Counter();
        // example: 不使用synchronized关键字同步
        Thread thread1 = new Thread(() -> {
            for (int i = 0;i<1000;i++){
                counter.incrementCount1();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0;i<1000;i++){
                counter.incrementCount1();
            }
        });
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        // 输出结果是不确定的，因为thread1,2共享了Counter对象，count1++不是原子操作
        System.out.println("Counter1: "+counter.getCount1());


        // example2,使用synchronized关键字同步
        Thread thread3 = new Thread(() -> {
            for (int i = 0;i<1000;i++){
                counter.incrementCount2();
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0;i<1000;i++){
                counter.incrementCount2();
            }
        });
        thread3.start();
        thread4.start();
        try{
            thread3.join();
            thread4.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 输出结果是2000，因为使用了synchronized关键字，
        System.out.println("Counter2: "+counter.getCount2());
    }
}
