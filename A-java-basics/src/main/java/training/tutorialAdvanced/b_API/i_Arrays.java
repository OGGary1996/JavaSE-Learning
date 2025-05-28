package training.tutorialAdvanced.b_API;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.random;

public class i_Arrays {
    public static void main(String[] args) {
        // 1. 数组的排序
        int[] arr = {3, 5, 1, 4, 2};
        Arrays.sort(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));
        String[] nameArr = {"John", "Alice", "Gary" ,"Bob","Amy"}; // 根据字母顺序排序
        Arrays.sort(nameArr);
        System.out.println("After Sorting: " + Arrays.toString(nameArr));
        String[] nameArr2 = {"John", "Alice", "Gary" ,"Bob","Amy"}; // 根据字母顺序排序
        Arrays.sort(nameArr2,1,5); // 部分排序，包左不包右
        System.out.println("After Partial Sorting: " + Arrays.toString(nameArr2));
            // 1.1 使用comparator修改排序的规则为降序,但是需要使用Integer类型
        Integer[] arrInteger = {3, 5, 1, 4, 2};
        Arrays.sort(arrInteger,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { // o1表示数组中的第一个元素，o2表示第二个元素
                return o2.compareTo(o1); // 通过正数和负数来判断插入的顺序
            }
        });
        System.out.println("After Sorting: " + Arrays.toString(arrInteger));

        // 2. 数组的二分查找，只能基于有序数组
        int[] arr2 = {1, 2, 3, 4, 5};
        int index = Arrays.binarySearch(arr2, 3);
        System.out.println("Index of 3: " + index);
        int index2 = Arrays.binarySearch(arr2, 2,4 ,3); // index: 2~4中的3
        System.out.println("Index of 3: " + index2);

        // 3. 数组的填充
        int[] arr3 = new int[10];
        Arrays.fill(arr3,5); // 5
        System.out.println("After Filling: " + Arrays.toString(arr3));
            // 同样可以使用部分填充

        // 4. 比较数组中的元素
        // 一维数组
        int[] arr4 = {1, 2, 3};
        int[] arr5 = {1, 2, 3};
        boolean isEqual = Arrays.equals(arr4, arr5);
        System.out.println("Are arr4 and arr5 equal? " + isEqual);
        // 二维数组
        int[][] arr6 = {{1, 2}, {3, 4}};
        int[][] arr7 = {{1, 2}, {3, 4}};
        boolean isEqual2 = Arrays.deepEquals(arr6, arr7);
        System.out.println("Are arr6 and arr7 equal? " + isEqual2);

        // 5.数组转换为List
        String[] strArr = {"Hello", "World"};
        List<String> list = Arrays.asList(strArr);
        // 注意：asList()方法返回的List是固定大小的，不能添加或删除元素
        // list.add("New Element"); // 会抛出UnsupportedOperationException
        // 如果修改了这个List中的元素，原数组也会被修改

        // 6.数组的复制
        // 在底层源码中使用了System.arraycopy()方法
        int[] arr8 = {1, 2, 3, 4, 5};
        int[] arr9 = Arrays.copyOf(arr8, 3); // 复制前3个元素
        System.out.println("Copied Array: " + Arrays.toString(arr9));
        int[] arr10 = Arrays.copyOf(arr8, 10); // 复制前10个元素，后面补0
        // 也可以使用部分复制

        // 7. 数组的转换String
        // 7.1 一维数组
        String[] strArr2 = {"Hello", "World"};
        String str = Arrays.toString(strArr2);
        System.out.println("String Representation: " + str);
        // 7.2 二维数组
        int[][] arr11 = {{1, 2}, {3, 4}};
        String str2 = Arrays.deepToString(arr11);
        System.out.println("String Representation: " + str2);

        // 8.数组的并行排序，使用与超大数组
        int[] arr12 = new int[1000000];
        for (int i = 0; i < arr12.length; i++) {
            arr12[i] = (int) (random() * 1000000);
        }
        long startTime = System.currentTimeMillis();
        Arrays.parallelSort(arr12);
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel Sort Time: " + (endTime - startTime) + "ms");
        // 判断是否排序成功
        boolean isSorted = true;
        for (int i = 0; i < arr12.length - 1; i++) {
            if (arr12[i] > arr12[i + 1]) {
                isSorted = false;
                break;
            }
        }

        // 9. 数组的转换为流，用于流操作
        int[] arr13 = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(arr13).sum(); // 求和

    }
}
