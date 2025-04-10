package f_ForkJoin;

// 本例子使用ForkJoin框架计算给定数组的所有元素的和
    // 求和的算法符合递归的算法逻辑

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer>{
    private int[] nums;
    private int left;
    private int right;
    private static final int THRESHOLD = 2; // 阈值, 小于2个元素时, 不再拆分任务,直接进行求和

    public SumTask(int[] nums, int left , int right){
        this.nums = nums;
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer compute(){
        if (right - left <= THRESHOLD){
            return nums[left] + nums[right];
        }
        // 拆分任务
        int mid = left + (right - left) / 2;
        SumTask leftTask = new SumTask(nums, left, mid);
        SumTask rightTask = new SumTask(nums, mid+1, right);
        // 执行任务
        leftTask.fork();
        int rightResult = rightTask.compute();
        int leftResult = leftTask.join();

        return leftResult + rightResult;
    }
}

public class a3_ForkJoin {
    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0 ; i < nums.length ; i++){
            nums[i] = (int)(Math.random() * 100);
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(nums, 0, nums.length-1);
        int result = pool.invoke(task);
        System.out.println("Result: " + result);
    }
}
