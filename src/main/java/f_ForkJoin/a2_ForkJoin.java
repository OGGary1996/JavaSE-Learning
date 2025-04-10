package f_ForkJoin;

// 本例子使用ForkJoin框架查找数组中的最大值
    // 查找最大值的算法符合递归的算法逻辑

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FindMaxTask extends RecursiveTask<Integer>{
    private int[] nums;
    private int left;
    private int right;
    private static final int THRESHOLD = 5; // 阈值, 小于5个元素时, 不再拆分任务,直接进行遍历获取最大值

    public FindMaxTask(int[] nums , int left, int right){
        this.nums = nums;
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer compute(){
        if(right - left <= THRESHOLD){
            int max = nums[left]; // 假设第一个元素是最大值，随后遍历剩余元素与其比较
            for (int i = left+1 ; i <= right ; i++){
                max = Math.max(max, nums[i]);
            }
            return max;
        }

        // 拆分任务
        int mid = left + (right - left) / 2;
        FindMaxTask leftTask = new FindMaxTask(nums,left,mid);
        FindMaxTask rightTask = new FindMaxTask(nums,mid+1,right);
        leftTask.fork();
        int rightResult = rightTask.compute();
        int leftResult = leftTask.join();

        return Math.max(leftResult, rightResult);
    }
}

public class a2_ForkJoin {
    public static void main(String[] args) {
        int[] nums = new int[30]; // 生成一个随机数组
        for (int i = 0; i < nums.length; i++){
            nums[i] = (int)(Math.random() * 100);
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        // 创建线程池
        ForkJoinPool pool = new ForkJoinPool();
        FindMaxTask task = new FindMaxTask(nums,0,nums.length-1);
        int result = pool.invoke(task);
        System.out.println("Result: " + result);
    }
}
