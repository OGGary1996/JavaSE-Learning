package training.tutorialAdvanced.c_collections.c_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class b_IntermediateOperations {
    public static void main(String[] args) {
        // 1. filter()方法, 过滤流中的元素
            // 接受一个Predicate函数式接口作为参数，实现类的test()方法返回true的元素会被保留，返回false的元素会被过滤掉
        List<String> fruitList = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "elderberry"));
        fruitList.stream().filter(fruit -> fruit.length() > 5).forEach(fruit -> System.out.println(fruit));
        System.out.println();

        // 2. map()方法, 映射流中的元素
            // 接受一个Function函数式接口作为参数，实现类的apply()方法会将流中的每个元素映射为一个新的元素
        fruitList.stream().map(fruit -> fruit.toUpperCase()).forEach(fruit -> System.out.println(fruit));
        System.out.println();

        // 3. flatMap()方法, 扁平化流中的元素
            // 接受一个Function函数式接口作为参数，实现类的apply()方法会将流中的每个元素映射为一个新的流，然后将所有的流合并为一个流
        List<List<String>> nestedList = new ArrayList<>();
        nestedList.add(new ArrayList<>(Arrays.asList("apple", "banana")));
        nestedList.add(new ArrayList<>(Arrays.asList("cherry", "date")));
        nestedList.add(new ArrayList<>(Arrays.asList("elderberry", "fig")));
        nestedList.stream().
                flatMap(list -> list.stream()).
                forEach(fruit -> System.out.println(fruit));
            // 此时将List -> list.stream(),将所有的List转换为Stream流，然后flatMap方法将所有的流合并为一个流
        System.out.println();

        // 4. distinct()方法, 去重流中的元素
            // 通过equals()和hashCode()方法判断元素是否相同
        fruitList.add("apple");
        fruitList.add("banana");
        fruitList.add("cherry");
        fruitList.stream().distinct().forEach(fruit -> System.out.println(fruit));
        System.out.println();

        // 5. sorted()方法, 排序流中的元素
            // 默认升序排序，接受一个Comparator函数式接口作为参数，可以自定义排序规则
        fruitList.stream().sorted().sorted().forEach(fruit -> System.out.println(fruit));
        System.out.println();
            // 可以传递一个Comparator函数式接口作为参数，进行自定义排序，但是前提是元素必须实现Comparable接口
        fruitList.stream().
                sorted(Comparator.reverseOrder()).
                forEach(fruit -> System.out.println(fruit));
        System.out.println();

        // 6. limit()方法, 截取流中的元素,skip()方法, 跳过流中的元素
            // 参数n为要截取或跳过的元素个数，与索引无关
        fruitList.stream().
                skip(3).
                limit(2).
                forEach(fruit -> System.out.println(fruit));
    }
}
