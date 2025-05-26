package training.tutorial.exampleThread;
// 使用 synchronized 关键字解决数据竞争问题
public class Counter2 {
    private int count = 0;
    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
