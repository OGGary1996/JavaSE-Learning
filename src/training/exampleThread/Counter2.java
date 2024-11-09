package training.exampleThread;
// 使用
public class Counter2 {
    private int count = 0;
    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
