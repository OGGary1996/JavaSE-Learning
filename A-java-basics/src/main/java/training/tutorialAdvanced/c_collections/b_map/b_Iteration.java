package training.tutorialAdvanced.c_collections.b_map;

import java.util.*;

public class b_Iteration {
    public static void main(String[] args) {
        /*
        Map的遍历逻辑其实只有一种，就是先取出元素作为Set或者Collection，然后再对这个Set/Collection进行遍历。
        Set：取出Key和entry对象时，由于不可重复性，我们使用Set集合；
        Collection：取出Value时，由于可重复性，我们使用Collection集合。
        */
        Map<Integer,String> studentMap = new HashMap<>();
        studentMap.put(1,"郭靖");
        studentMap.put(2,"杨过");
        studentMap.put(3,"张无忌");
        studentMap.put(4,"赵敏");
        studentMap.put(5,"小龙女");

        // 使用Map中的forEach方法进行遍历,这个方法需要传递一个BiConsumer接口的实现类，这个实现类可以传递两个参数
        studentMap.forEach((key,value) -> System.out.println(key + "==》" + value));

        // 1,通过获取entry对象进行遍历
        Set<Map.Entry<Integer,String>> entrySet = studentMap.entrySet();
            // 1.1 使用enhanced for loop
        for (Map.Entry<Integer,String> entry : entrySet){
            System.out.println(entry.getKey() + "==》" +entry.getValue());
        }
            // 1.2 使用iterator
        Iterator<Map.Entry<Integer,String>> it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> entry = it.next();
            System.out.println(entry.getKey() + "==》" +entry.getValue());
        }
            // 1.3 使用Lambda表达式
        entrySet.forEach(entry -> System.out.println(entry.getKey() + "==》" +entry.getValue()));


        // 2,通过获取key对象进行遍历
        Set<Integer> keySet = studentMap.keySet();
            // 2.1 使用enhanced for loop
        for (Integer key : keySet){
            System.out.println(key + "==》" + studentMap.get(key));
        }
            // 2.2 使用iterator
        Iterator<Integer> it2 = keySet.iterator();
        while (it2.hasNext()){
            Integer key = it2.next();
            System.out.println(key + "==》" + studentMap.get(key));
        }
            // 2.3 使用Lambda表达式
        keySet.forEach(key -> System.out.println(key + "==》" + studentMap.get(key)));

        // 3,通过获取value对象进行遍历
        // 注意：由于value是可重复的，所以我们使用Collection集合
        Collection<String> valueList = studentMap.values();



    }
}
