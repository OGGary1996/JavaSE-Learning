package training.tutorial;
import java.util.Map;
import java.util.HashMap;
/* 
    Map 是一个用于存储键值对（Key-Value Pairs）的数据结构。
    它是集合框架的一部分，但与 Collection 接口不同，因为它不是存储单一元素，而是以键值对的形式存储数据。
*/ 
/*
 *特点：
    * 1. Map 是一个接口，它是一个键值对的集合。
    * 2. Map 中的键是唯一的，值可以重复。
    * 3. 通过键快速访问对应的值，而不是依赖索引。
    * 4. 如果插入的键已经存在，新值会覆盖旧值。
 */

public class x_Collection_API2_Maps {
    public static void main(String[] args){
    // 创建一个HashMap对象，键是String类型，值是Integer类型
    // HashMap是Map接口的一个实现类
        Map<String , Integer> fruits = new HashMap<String, Integer>();
        fruits.put("Apple",10); // 使用.put()方法添加键值对
        fruits.put("Orange",15);
        fruits.put("Banana",20);
        fruits.put("Grape",25);

        // 使用.get()方法获取键对应的值
        System.out.println("Value: " + fruits.get("Banana"));
        // 使用.remove()方法删除键值对
        fruits.remove("Grape");
        // 使用.containsKey()方法判断是否包含某个键
        System.out.println("Contains Key: " + fruits.containsKey("Grape"));

        // 遍历
        // 使用.keySet()方法获取所有的键，Map中的所有键组成一个Set集合,再使用for循环.get()方法获取value
        for (String key : fruits.keySet()){
            System.out.println("Fruits: " + key + ", Value: " + fruits.get(key));
        }

        Map<String,Integer> cars = new HashMap<String, Integer>();
        cars.put("Mazda", 2009);
        cars.put("Audui", 2019);
        cars.put("Subar",2016);
        for (String key : cars.keySet()){
            System.out.println("Brand: " + key + "Year: " + cars.get(key));
        }

    }
}
