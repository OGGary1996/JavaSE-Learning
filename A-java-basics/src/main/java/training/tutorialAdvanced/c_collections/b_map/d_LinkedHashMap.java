package training.tutorialAdvanced.c_collections.b_map;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* 它继承了 HashMap 的所有功能。
* 额外维护了一条 双向链表，记录了每个节点插入的顺序。
* 因此在遍历时，顺序是有保证的：默认是按插入顺序（也可以按访问顺序）。
*/

public class d_LinkedHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
