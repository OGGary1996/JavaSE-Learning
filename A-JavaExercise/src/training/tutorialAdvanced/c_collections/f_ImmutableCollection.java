package training.tutorialAdvanced.c_collections;

import java.util.*;

public class f_ImmutableCollection {
    public static void main(String[] args) {
        // List, Set, Map都有对应的方法创建不可变集合
        // List.of()
        List<String> demoList = List.of("a", "b", "c");
        // Set.of()
        Set<Integer> demoIntSet = Set.of(1, 2, 3);
        // Map.of(),这种方式只能存储10个键值对
        Map<Integer,String> demoMap = Map.of(1,"a", 2,"b", 3,"c");
        // Map.ofEntries(),这种方式可以存储任意数量的键值对
        Map<Integer,String> demoMap2 = Map.ofEntries(
                Map.entry(1, "a"),
                Map.entry(2, "b"),
                Map.entry(3, "c"),
                Map.entry(4, "d"),
                Map.entry(5, "e"),
                Map.entry(6, "f"),
                Map.entry(7, "g"),
                Map.entry(8, "h"),
                Map.entry(9, "i"),
                Map.entry(10, "j")
        );

        // 将可变集合转换为不可变集合
        List<Integer> demoList1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> demoList2 = Collections.unmodifiableList(demoList1);
            // ......
    }
}
