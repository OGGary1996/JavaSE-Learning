package training.tutorialAdvanced.c_collections.a_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class g_Set {
    public static void main(String[] args) {
        // Set集合的特点是无索引、不可重复的元素集合
        // Set集合的实现类有HashSet、LinkedHashSet、TreeSet
        // HashSet：无序、不可重复
        Set<Integer> demoSet = new HashSet<>();
        // 方法与Collection的方法一致
        demoSet.add(1);
        demoSet.add(2);
        demoSet.add(3);
        demoSet.add(4);
        demoSet.add(5);
        demoSet.add(6);
        demoSet.add(7);
        demoSet.add(3); // 此时返回值为false
        System.out.println(demoSet);
        // 遍历方式：
        // 1.增强for循环
        for (Integer i : demoSet){
            System.out.println(i);
        }
        // 2.迭代器
        Iterator it = demoSet.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        // 3.for-each循环
        demoSet.forEach(i -> System.out.println(i));
        demoSet.forEach(System.out::println);

        // LinkedHashSet：有序、不可重复
        Set<String> demoSet2 = new LinkedHashSet<>();
        demoSet2.add("a");
        demoSet2.add("b");
        demoSet2.add("c");
        demoSet2.add("d");
        demoSet2.add("e");
        demoSet2.add("f");
        System.out.println(demoSet2);
    }
}
