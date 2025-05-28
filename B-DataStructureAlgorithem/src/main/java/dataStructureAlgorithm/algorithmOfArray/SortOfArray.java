package dataStructureAlgorithm.algorithmOfArray;

public class SortOfArray {

    // Determine whether the array is sorted
    public static boolean isSorted(int[] array){
        for (int i = 0;i < array.length-1; i++){
            if (array[i] > array[i+1]){ // If the current element is greater than the next element, the array is not sorted
                return false; // return false
            }
        }
        return true;
    }


    // bobble sort
    public static void bobbleSort(int[] array){
        if (isSorted(array)){
            System.out.println("Array you passed is already sorted.");
            return; // If the array is already sorted, return directly
        }
        for (int i = 0; i < array.length-1; i++){
            for (int j = 0; j < array.length-1-i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println("Array is sorted, the result is:");
        for (int num : array){
            System.out.print(num + " ");
        }
    }


    // Selection sort
    public static void selectionSort(int[] array){
        if(isSorted(array)){
            System.out.println("This array is already sorted.");
        }
        for (int i = 0; i < array.length-1; i++){
            int minIndex = i;
            for (int j = i+1; j < array.length; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println("Array is sorted, the result is:");
        for (int num : array){
            System.out.print(num + " ");
        }
    }


    // insertion sort
    public static void insertionSort(int[] array){
        if (isSorted(array)){
            System.out.println("This array is already sorted.");
        }
        for (int i = 1; i < array.length; i++){
            int current = array[i];
            int j = i-1;
            while (j >= 0 && array[j] > current){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        System.out.println("Array is sorted, the result is:");
        for (int num : array){
            System.out.print(num + " ");
        }
    }
}