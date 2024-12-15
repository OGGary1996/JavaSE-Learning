package training.dataStructureAlgorithm.exampleclass;

public class search {
    public static int step;

    public static int LinearSearch(int target, int[] array){
        step = 0;
        for (int i = 0; i < array.length; i++){
            step++;
            if (target == array[i]){
              return i;
            }
        }
        return -1;
    }

//    public static int BinarySearch(int target, int[] array){
//        step = 0;
//        int left = 0;
//        int right = array.length - 1;
//        int mid = (left + right) / 2;
//        while (left <= right){
//            step++;
//            if (target == array[mid]) {
//                return mid;
//            } else if (target < array[mid]) {
//                right = mid - 1;
//            }else {
//                left = mid + 1;
//            }
//        }
//        return -1;
//    }

    public static int BinarySearch(int target, int[] array, int left , int right){
        step++;
        int mid = (left + right) / 2;
        if (left <= right){
            if (target == array[mid]){
                return mid;
            }else if (target < array[mid]){
                return BinarySearch(target, array, left, mid - 1);
            }else {
                return BinarySearch(target, array, mid + 1, right);
            }
        }
        return -1;
    }
}
