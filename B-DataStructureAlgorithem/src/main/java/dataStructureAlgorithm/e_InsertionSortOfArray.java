package dataStructureAlgorithm;

import dataStructureAlgorithm.algorithmOfArray.SortOfArray;

public class e_InsertionSortOfArray {
    public static void main(String[] args){
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++){
            nums[i] = (int)(Math.random()*100);
        }
        SortOfArray.insertionSort(nums);
    }
}
