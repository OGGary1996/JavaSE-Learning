package training.tutorialAdvanced.b_API;

import java.util.Arrays;
import java.util.Comparator;

public class j_Lambda {
    public static void main(String[] args) {
        // Lambda 表达式的使用
        // 1.只能在函数时接口为基础时使用。
        // 2.省略规则：
            // 2.1 参数类型可以省略
            // 2.2 如果只有一个参数，()可以省略
            // 2.3 如果方法体只有一行代码，{}，; ， return 可以省略。但是必须同时省略。
        // example：
        Integer[] arr = {3, 5, 1, 4, 2};
        // 完整实现：
//        Arrays.sort(arr,new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1,Integer o2){
//                return o2.compareTo(o1);
//            }
//        });
//        // 使用Lambda表达式
//        Arrays.sort(arr,(Integer o1 , Integer o2) -> {
//            return o2.compareTo(o1);
//        });
        // 省略Lambda表达式
        Arrays.sort(arr,(o1,o2) -> o2.compareTo(o1));
        // 验证
        System.out.println("After sorting: " + Arrays.toString(arr));


        // 使用Lambda表达式，实现Comparator接口,针对字符串数组中的字符串元素的长度进行降序排序
        String[] name = {"Mohammad","Amy","Gary","Bob","Alice"};
        // 完整实现：
//        Arrays.sort(name,new Comparator<String>() {
//            @Override
//            public int compare(String str1,String str2){
//                return str2.length() - str1.length(); // 降序
//            }
//        });
        // 使用Lambda表达式
        Arrays.sort(name,(String s1,String s2) -> s2.length()-s1.length());

        // 验证
        System.out.println("After sorting: " + Arrays.toString(name));



    }
}
