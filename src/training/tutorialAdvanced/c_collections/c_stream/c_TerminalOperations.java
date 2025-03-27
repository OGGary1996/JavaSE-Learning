package training.tutorialAdvanced.c_collections.c_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class c_TerminalOperations {
    public static void main(String[] args) {
        // 1. forEach()方法, 遍历流中的元素
        // 2. collect()/toArray()方法, 收集流中的元素,作为集合或数组返回
            // 2.1 collect()方法, 收集流中的元素,作为集合返回
                // 2.1.1 toList()方法, 收集流中的元素,作为List集合返回
                // 2.1.2 toSet()方法, 收集流中的元素,作为Set集合返回
        List<String> fruitList = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape"));
        List<String> subList = fruitList.stream().
                filter(fruit -> fruit.length() > 5).
                collect(Collectors.toList());
                // 2.1.3 toMap()方法, 收集流中的元素,作为Map集合返回
        Map<Integer,String> subMap1 = fruitList.stream().collect(Collectors.toMap(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.hashCode();
            }
        }, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase();
            }
        }));
        // 等同于
        Map<Integer,String> subMap2 = fruitList.stream().
                skip(3).limit(3).
                collect(Collectors.toMap(fruit -> fruit.hashCode(), fruit -> fruit.toUpperCase()));
            // 2.2 toArray()方法, 收集流中的元素,作为数组返回
                // 2.2.1 toArray()方法如果传递空参，返回Object[]类型的数组
        Object[] arr1 = fruitList.stream().toArray();
                // 2.2.2 toArray()方法可以传递IntFunction函数式接口作为参数，其中重写的方法是apply()方法，这个方法传递的int变量用于接收stream内部处理的元素个数，apply方法内部会创建一个指定大小的数组并返回
        String[] arr2 = fruitList.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        String[] arr3 = fruitList.stream().toArray(value -> new String[value]);


        // 3. count()，max(), min()方法, 对流中的元素聚合处理
            // max，min方法中的参数是一个Comparator函数式接口，可以自定义排序规则
            // 如果最后不使用orElse()方法，返回Optional类型的对象,Optional是一个容器对象，表示可能存在或不存在的值
        long count = fruitList.stream().count();
        String max = fruitList.stream().max(String::compareTo).orElse(null); // 排序规则是字典序
        String min = fruitList.stream().min(String::compareTo).orElse(null); // 排序规则是字典序

        // 4.anyMatch(), allMatch(), noneMatch()方法, 判断流中的元素是否满足某个条件
            // 接受一个Predicate函数式接口作为参数，实现类的test()方法返回boolean
        boolean anyMatch = fruitList.stream().anyMatch(fruit -> fruit.length() > 5); // 是否有元素长度大于5
        boolean allMatch = fruitList.stream().allMatch(fruit -> fruit.length() > 5); // 是否所有元素长度都大于5
        boolean noneMatch = fruitList.stream().noneMatch(fruit -> fruit.length() > 5); // 是否没有元素长度大于5

    }
}
