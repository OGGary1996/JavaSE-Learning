package g_ForkJoin;

// 本例子使用ForkJoin框架，通过RecursiveAction类实现数组的排序
// 排序的算法符合递归的算法逻辑

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class SortArray extends RecursiveAction { // RecursiveAction类不需要返回类型，无返回值
    private int[] nums;
    private int left;
    private int right;
    private static final int THRESHOLD = 5; // 阈值, 小于5个元素时, 不再拆分任务,直接进行排序

    public SortArray(int[] nums, int left ,int right){
        this.nums = nums;
        this.left = left;
        this.right = right;
    }

    @Override
    public void compute(){
        if (right - left <= THRESHOLD){
            // 直接使用Arrays.sort()方法进行排序
            Arrays.sort(nums, left, right+1); // 注意这里的right+1，因为Arrays.sort()方法的right参数是开区间
            return;
        }

        // 拆分任务
        int mid = left + (right - left) / 2;
        SortArray leftTask = new SortArray(nums, left, mid);
        SortArray rightTask = new SortArray(nums, mid+1, right);
        invokeAll(leftTask, rightTask); // invokeAll()方法会异步的执行任务

        // 合并结果
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left , int mid , int right){
        int[] temp = new int[right-left+1]; // 临时数组用于存放合并后的结果
        int i = left;
        int j = mid+1;
        int k = 0 ;
        while(i <= mid && j <= right){
            if (nums[i] <= nums[j]){
                temp[k] = nums[i];
                i++;
            }else{
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        // 将剩余元素拷贝到temp数组中
        while(i <= mid){
            temp[k] = nums[i];
            i++;
            k++;
        }
        while(j <= right){
            temp[k] = nums[j];
            j++;
            k++;
        }

        System.arraycopy(temp, 0, nums, left, temp.length);

    }

}

public class a4_ForkJoin {
    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0 ; i < nums.length ; i++){
            nums[i] = (int)(Math.random() * 100);
        }
        System.out.println("Before Sort:");
        for (int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();

        ForkJoinPool pool = new ForkJoinPool();
        SortArray task = new SortArray(nums,0,nums.length-1);
        pool.invoke(task);

        System.out.println("After Sort:");
        for (int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
