package dataStructureAlgorithm;

import dataStructureAlgorithm.algorithmOfArray.SearchOfArray;

import java.util.Arrays;

public class a_LinearSearchOfArray {
    public static void main(String[] args){
        int[] nums = new int[500]; // Declare an array of integers
        for (int i = 0; i < nums.length; i++){
            nums[i] = (int)(Math.random()*100); // Randomly generate elements and insert them into the array
        }
        Arrays.sort(nums); // Sort the array

        if(SearchOfArray.LinearSearch(7,nums) == -1){
            System.out.println("Target not found");
            System.out.println("Linear SearchOfArray took " + SearchOfArray.step + " steps");
        }else{
            System.out.println("Target found at index: " + SearchOfArray.LinearSearch(7,nums));
            System.out.println("Linear SearchOfArray took " + SearchOfArray.step + " steps");
        }
    }
}
