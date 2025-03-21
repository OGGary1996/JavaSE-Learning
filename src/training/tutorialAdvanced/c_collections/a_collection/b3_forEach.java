package training.tutorialAdvanced.c_collections.a_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class b3_forEach {
    public static void main(String[] args) {
        // 使用forEach遍历集合,适用于简单的遍历情况
        List<Integer> numList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        // 使用forEach遍历集合
        // forEach方法是Java8引入的一个新特性，它可以简化集合的遍历
        /* 这个方法接受一个Consumer接口的实现类作为参数，Consumer接口中的方法是accept
           而在forEach方法的底层，实际上是使用for循环去遍历集合，并且在每次遍历时都调用Consumer的accept方法；
           所以我们在重写accept方法时，实际上就是在实现for循环的逻辑
        */
        numList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) { // 这里的integer直接代表了集合中的元素
                System.out.println("Element: " + integer);
            }
        });
        // 使用Lambda表达式遍历集合
        numList.forEach(i -> System.out.println("Element: " + i));
        // 使用方法引用遍历集合
        numList.forEach(System.out::println);
        // 什么是方法引用：
            // 1.方法引用是Java8引入的一种新特性，它可以简化Lambda表达式的写法
            // 2.方法引用的语法是：类名::方法名
            // 3.方法引用可以是静态方法、实例方法或构造方法
            // 4.方法引用的参数列表和返回值类型必须与Lambda表达式一致
            // 5.方法引用的使用场景：当Lambda表达式只是调用一个方法时，可以使用方法引用来简化代码
            // 6.方法引用的优点：简洁、可读性强
    }
}
