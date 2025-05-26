package training.tutorialAdvanced.c_collections;
// Collections提供了一系列的方法来操作集合类


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class e_Collections {
    public static void main(String[] args) {
        List<Integer> demoList = new ArrayList<>(Arrays.asList(243,123,456,789,234,567,890, 234,567,890));
        // 打乱顺序
        Collections.shuffle(demoList);
        System.out.println("After shuffle: " + demoList);
        // sort方法
        Collections.sort(demoList);
        System.out.println("After sort: " + demoList);
        // 二分查找
        int index = Collections.binarySearch(demoList,890);
        System.out.println("Index of 890: " + index);
        // 反转
        Collections.reverse(demoList);
        System.out.println("After reverse: " + demoList);
        // 交换位置
        Collections.swap(demoList,0,1); // 交换第0个和第1个元素
        System.out.println("After swap: " + demoList);
        // 添加多个元素
        Collections.addAll(demoList,123,3123,4345,234366,1232,1231,235);
        System.out.println("After addAll: " + demoList);
    }
}
