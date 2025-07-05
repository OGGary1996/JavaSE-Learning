package i_ForkJoin;

// 本例子使用ForkJoin框架计算从0开始的斐波那契数列的第n项(index从0开始)
    // 斐波那契数列符合递归的算法

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FibonacciTask extends RecursiveTask<Integer> {
    private int index;
    public FibonacciTask(int index){
        this.index = index;
    }

    @Override
    public Integer compute(){
        if (index <= 1){ // 递归结束的最小单元
            return index;
        }
        // 拆分任务
        FibonacciTask task1 = new FibonacciTask(index - 1);
        FibonacciTask task2 = new FibonacciTask(index - 2);
        // 执行任务
        task1.fork(); // fork()方法会异步的执行任务, 将任务1放入线程队列
        int result2 = task2.compute(); // 在主线程中执行任务2
        int result1 = task1.join(); // 等待task1执行, 并获取结果
        return result1 + result2;
    }
}

public class a1_ForkJoin {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(5);
        int result = pool.invoke(task);
        System.out.println("Result: " + result);
    }
}


