package dataStructureAlgorithm;

import dataStructureAlgorithm.algorithmOfArray.QuickSortOfArray;

public class f_QuickSortOfArray {
    public static void main(String[] args){
        int[] nums = new int[100];
        for(int i = 0; i < nums.length; i++){
            nums[i] = (int)(Math.random()*100);
        }
        QuickSortOfArray.quickSort(nums,0,nums.length-1);
        System.out.println("Array is sorted, the result is:");
        for (int num : nums){
            System.out.print(num + " ");
        }
    }
}
