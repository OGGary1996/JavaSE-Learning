package training.tutorialAdvanced.c_collections.b_map;

import java.util.HashMap;
import java.util.Map;

public class a_MethodsOfMap {
    public static void main(String[] args) {
        Map<String,String> coupleMap = new HashMap<>();
        // 1.添加操作；返回值：如果key已经存在，则返回被替换掉的value；如果key不存在，则返回null，因为没有替换任何value
        coupleMap.put("郭靖","黄蓉");
        coupleMap.put("杨过","小龙女");
        coupleMap.put("张无忌","赵敏");
        System.out.println("添加操作后，coupleMap = " + coupleMap);
        // 2.获取操作，通过key获取value
        System.out.println(coupleMap.get("杨过")); // 小龙女
        // 3.删除操作，返回值：被删除的value
        System.out.println("Value has been deleted: " + coupleMap.remove("张无忌")); // 赵敏
        System.out.println("删除操作后，coupleMap = " + coupleMap);
        // 4.判断操作
            // 4.1 判断是否存在，与Collection集合的contains()方法类似
            // 注意：contains方法在底层使用的是equals方法进行判断的，如果元素的equals方法没有被重写，则会使用Object类的equals方法进行判断
            //     这会导致实际上在比较的时候内存地址，如果元素的属性字段都相同，但是由于是不同的对象，所以导致存在判断误判
        System.out.println("Is key 张无忌 exist? " + coupleMap.containsKey("张无忌")); // false
        System.out.println("Is value 赵敏 exist? " + coupleMap.containsValue("赵敏")); // false
            // 4.2 判断是否为空
        System.out.println("Map is empty? " + coupleMap.isEmpty()); // false
            // 4.3 判断大小
        System.out.println("Map size: " + coupleMap.size()); // 2
        // 5.清空操作
        coupleMap.clear();
        System.out.println("清空操作后，coupleMap = " + coupleMap);

    }
}
