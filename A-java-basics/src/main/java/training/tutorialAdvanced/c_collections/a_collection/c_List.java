package training.tutorialAdvanced.c_collections.a_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class c_List {
    public static void main(String[] args) {
        // List 除了Collection之外特有的方法，这些方法依赖于索引
        List<String> fruits = new ArrayList<>();
        // 1. add(),addAll()
        fruits.add("Apple"); // 默认添加到末尾
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add(1, "Grape"); // 根据索引插入
        fruits.add(3, "Mango");
        List<String> subFruits = new ArrayList<>(Arrays.asList("Peach", "Cherry", "Pineapple"));
        fruits.addAll(0,subFruits); // 将子集合添加到指定位置
        // 2. remove()，removeAll()
            // 注意：remove()方法可以根据索引或对象删除元素，
            // 在调用具有重载属性的方法时，方法调用会优先考虑传递参数与形参类型一致的方法；如果传递int，则会优先考虑调用remove(index int)
        fruits.remove("Grape"); // 删除指定元素
        // 3. get(),set()
        System.out.println("Fruit as Index 2 is " + fruits.get(2)); // 获取指定索引的元素
        fruits.set(0,"Coconut"); // 替换指定索引的元素
        // 4. indexOf(), lastIndexOf()
        System.out.println("Index of Banana is " + fruits.indexOf("Banana")); // 获取指定元素的索引
        System.out.println("Last Index of Banana is " + fruits.lastIndexOf("Banana")); // 获取指定元素的最后索引
        // 5. subList(),获取子列表
        fruits.subList(1, 3).clear(); // 清除指定范围的元素

        // List特有的遍历，使用ListIterator
        // 由于迭代器中的指针不会复位，所以在使用反向遍历时，必须要先正向遍历一次
        // ListIterator是Iterator的子接口，ListIterator可以在遍历时进行插入和删除操作
        ListIterator<String> it = fruits.listIterator();
            // 1.正向遍历
        while(it.hasNext()){
            if (it.next().equals("Apple")){
                it.set("Pineapple"); // 替换当前元素
            }
            if (it.next().equals("Banana")){
                it.add("Strawberry"); // 在当前元素后插入新元素
            }
            if (it.next().equals("Orange")){
                it.remove(); // 删除当前元素
            }
        }
            // 2.反向遍历
        while(it.hasPrevious()){
            System.out.println(it.previous());
        }

    }
}
