package training.tutorial;
// 线程安全是在多线程环境下，正确处理线程并发。即使多个线程同时访问修改同一资源，也不会导致错误，保证数据的一致性，避免数据的冲突。
/*
    在多线程程序中，如果多个线程同时访问共享数据（如变量、对象），就会引发并发问题，比如数据竞争、死锁等。因此，线程安全确保：
	1.	数据一致性：无论多少线程访问，数据的状态总是一致、可靠的。
	2.	无数据竞争：多个线程同时读取、写入或更新数据时，不会相互干扰或破坏数据。
	3.	并发问题控制：避免由于线程不当操作引发的问题，如死锁、资源饥饿等。
 */
import training.tutorial.exampleThread.Counter1;
import training.tutorial.exampleThread.Counter2;

public class w_Thread3_Safe {
    public static void main(String[] args){
        // example: 数据竞争和冲突
        /*
            Counter counter = new Counter(); t1和t2两个线程同时访问counter1中的increment()；
            而这个方法中有一个count++操作，这个操作不是原子操作，而是分为三个步骤：
            1. 读取count的值
            2. 将count的值加1
            3. 将count的值写入内存
            所以，如果t1和t2同时访问increment()，就会出现数据竞争，导致count的值不正确。
            例如，某个时刻t1读取count的值为1，这时t2同时读取count的值为1，然后t1将count的值加1，写入内存，此时count的值为2；而实际上应该是3。
        */
        Counter1 counter1 = new Counter1();
        Runnable a = () -> {
            for (int i = 0; i< 1000; i++){
                counter1.increment();
            }
        };
        Thread t1 = new Thread(a);
        t1.start();

        Runnable b = () -> {
            for (int i = 0; i <= 1000; i++){
                counter1.increment();
            }
        };
        Thread t2 = new Thread(b);
        t2.start();

        System.out.println(counter1.getCount());// 每一次运行的结果都不一样，因为数据竞争导致count的值不正确

        // 解决方法：在需要被实例化运行的的class声明中使用synchronized关键字

        Counter2 counter2 = new Counter2();
        Runnable c = () -> {
            for (int i = 0; i<= 1000; i++){
                counter2.increment();
            }
        };
        Thread t3 = new Thread(c);
        t3.start();

        Runnable d = () -> {
            for (int i = 0; i <= 1000; i++){
                counter2.increment();
            }
        };
        Thread t4 = new Thread(d);
        t4.start();

        System.out.println(counter2.getCount());

    }
}
