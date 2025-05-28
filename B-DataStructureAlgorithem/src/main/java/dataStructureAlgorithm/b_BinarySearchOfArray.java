package dataStructureAlgorithm;

import dataStructureAlgorithm.algorithmOfArray.SearchOfArray;

import java.util.Arrays;

public class b_BinarySearchOfArray {
    public static void main(String[] args){
        int[] nums = new int[500];
        for (int i = 0; i < nums.length; i++){
            nums[i] = (int)(Math.random()*100); // Randomly generate elements and insert them into the array
        }
        Arrays.sort(nums);

        if (SearchOfArray.BinarySearchByRecursive(50,nums,0,nums.length-1) == -1) {
            System.out.println("Target not found");
            System.out.println("Binary SearchOfArray took " + SearchOfArray.step + " steps");
        }else {
            System.out.println("Target found at index: " + SearchOfArray.BinarySearchByRecursive(50,nums,0,nums.length-1));
            System.out.println("Binary SearchOfArray took " + SearchOfArray.step + " steps");
        }
    }
}
