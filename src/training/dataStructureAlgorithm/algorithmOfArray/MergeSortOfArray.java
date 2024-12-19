package training.dataStructureAlgorithm.algorithmClass;

public class mergeSortOfArray {
    public static void mergeSort(int[] array,int left, int right){
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    static void merge(int[] array, int left ,int mid, int right){
        int leftSize = mid-left+1;
        int rightSize = right-mid;

        int[] leftArray = new int[leftSize]; // create left array(temporary)
        int[] rightArray = new int[rightSize]; // create right array(temporary)

        // copy data to left and right array from the original array
        for (int i = 0; i < leftSize; i++){
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < rightSize; j++){
            rightArray[j] = array[mid + 1 + j];
        }

        // merge the left and right array to the original array
        int i = 0; // represent the index of left array
        int j = 0; // represent the index of right array
        int k = left; // represent the index of original array
        while (i < leftSize && j < rightSize){
            if(leftArray[i] <= rightArray[j]){
                array[k] = leftArray[i];
                i++;
            }else{
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // copy the remaining elements of left array
        while(i<leftSize){
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while(j<rightSize){
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
