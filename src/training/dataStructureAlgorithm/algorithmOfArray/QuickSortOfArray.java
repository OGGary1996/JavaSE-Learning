package training.dataStructureAlgorithm.algorithmOfArray;

public class QuickSortOfArray extends SortOfArray {
    // Quick sort - main function
    public static void quickSort(int[] array, int low, int high){
        if (low < high) {
            int pivot = partition(array, low, high); // get the pivot
            // recursively sort the left and right parts of the pivot
            quickSort(array, low, pivot - 1); // left part
            quickSort(array, pivot + 1, high); // right part
        }
    }

    //partition
    static int partition(int[] array,int low,int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
