package dataStructureAlgorithm;

import dataStructureAlgorithm.algorithmOfArray.MergeSortOfArray;

public class g_MergeSortOfArray {
    public static void main(String[] args){
        int[] nums = new int[100];
        for(int i = 0; i < nums.length; i++){
            nums[i] = (int)(Math.random()*100);
        }
        MergeSortOfArray.mergeSort(nums,0,nums.length-1);
        System.out.println("Array is sorted now: ");
        for (int num : nums){
            System.out.print(num + " ");
        }
    }
}
