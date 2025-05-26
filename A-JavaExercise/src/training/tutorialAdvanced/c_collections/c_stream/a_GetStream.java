package training.tutorialAdvanced.c_collections.c_stream;

import java.util.*;
import java.util.stream.Stream;

public class a_GetStream {
    public static void main(String[] args) {
        // 1, 单列集合获取流，List 和Set都可以
        // 使用Collection接口中的默认方法stream()获取流
        List<String> demoList1 = new ArrayList<>();
        Collections.addAll(demoList1,"Hello!","World!","Java!","Stream!");
        demoList1.stream().forEach(s -> System.out.print(s));
        System.out.println();

        // 2. 双列集合获取流，双列集合无法直接获取Stream，需要先转换为单列集合
        Map<Integer,String> demoMap1 = new HashMap<>();
        demoMap1.put(1,"Hello!");
        demoMap1.put(2,"World!");
        demoMap1.put(3,"Java!");
        demoMap1.put(4,"Stream!");
            // 2.1 获取Map的keySet()，转换为Set集合
        Set<Integer> demoKeySet1 = demoMap1.keySet();
        demoKeySet1.stream().forEach(s -> System.out.print(s + "=" +demoMap1.get(s)));
        System.out.println();
            // 2.2 获取Map的entrySet()，转换为Set集合
        Set<Map.Entry<Integer,String>> demoEntrySet1 = demoMap1.entrySet();
        demoEntrySet1.stream().forEach(s -> System.out.print(s.getKey() + "=" + s.getValue()));
        System.out.println();

        // 3. 数组获取流,通过Arrays.stream()方法获取流
        String[] demoArray1 = {"Hello!","World!","Java!","Stream!"};
        Arrays.stream(demoArray1).forEach(a -> System.out.print(a));
        System.out.println();

        // 4. Stream.of()方法获取流,适用于获取零散的对象，但是必须是相同类型的对象，不能是基本数据类型，只能是引用数据类型
            // 方法的底层会调用Arrays.asList()方法，会讲元素自动封装为对象数组
            // 不能直接传递基本数据类型的数组，否则会将整个数组作为一个对象传递，而非数组中的元素
        Stream.of("Hello!","World!","Java!","Stream!").forEach(a -> System.out.print(a));
    }
}
