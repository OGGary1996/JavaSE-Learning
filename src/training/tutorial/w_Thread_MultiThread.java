package training.tutorial;
import training.tutorial.exampleThread.ThreadA;
import training.tutorial.exampleThread.ThreadB;

// Thread中的start方法会启动一个线程，然后调用run方法，run方法中的代码会在线程启动时执行。
    // 所以不能直接调用run方法，必须调用start方法，启动线程。
    // 如果直接调用run方法，那么run方法中的代码会在当前的Main线程中执行，而不会启动一个新的线程；这跟调用一个普通的方法是一样的。
// Thread中的方法只能被调用一次，如果需要多次调用，需要重新创建一个Thread对象。
public class w_Thread_MultiThread {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start(); // 3. start the thread
        threadB.start();
        // 结果是ThreadA和ThreadB交替执行，因为线程是并发执行的。

    
// 并发并不等于真正的同时执行。即使有多个线程，CPU 资源仍然是有限的。
// 在单核 CPU 或线程数量超过可用核心数的情况下，线程会轮流获得 CPU 时间片，并不是真正意义上的“同时”执行。
// 因此，线程优先级为系统提供了一种任务调度的指导，让某些线程在资源争用时有更高的执行优先权。
// 但是，线程优先级并不是绝对的，只是一个相对的概念，CPU 仍然会以某种算法来调度线程，而不是绝对按照线程优先级来执行。
        // 查看线程的优先级 从1到10，1是最低优先级，10是最高优先级，默认为5
        System.out.println(threadA.getPriority()); // 输出5

        // 设置线程的优先级
        threadA.setPriority(10);
        threadA.setPriority(Thread.MAX_PRIORITY); // 10

        // 手动控制线程执行之后的间隔时间，单位是毫秒
        try {
            Thread.sleep(10); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
