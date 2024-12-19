package training.tutorial;
import java.util.List; // 继承自Collection接口
import java.util.Set; // 继承自Collection接口
// import java.util.function.Consumer;

import training.tutorial.exampleClass.CarInfo;

import java.util.ArrayList; // 继承自List接口
import java.util.HashSet; // 继承自Set接口


/* 
    *Collection API：像一个“工具箱”，包含了各种集合相关的工具；是一个整体框架。
    *Collection：是“工具箱”中的一个通用接口，定义了集合的核心功能。
    *Collections：是“工具箱外面的说明书”，提供了一些快速使用工具的技巧和辅助功能。
*/
import java.util.Iterator;

/*
    * Collection 是集合框架中的一个顶级接口，用于表示一组单一元素的集合。
    * Collection 接口是 List、Set 和 Queue 接口的父接口。
    * Collection 主要用于操作集合内部，接口中定义了一系列方法。
 */
public class x_CollectionAPI1_Collection {
    public static void main(String[] args){
        // Example 1: List接口(其中的ArrayList类)
        List<Integer> nums = new ArrayList<Integer>(); // 创建一个ArrayList对象 nums
        // 使用Collection接口中的方法
        nums.add(6);
        nums.add(2);
        nums.add(8);
        nums.add(15);
        nums.add(6);
        nums.add(8);
        // 使用.indexOf()方法,获取对应元素的索引
        for (Integer num : nums){
            System.out.println(num + " index: " + nums.indexOf(num));
        }
        // 使用.size()方法获取集合的大小，并且使用.get()方法获取对应索引的元素
        for (int i = 0; i < nums.size(); i++){
            System.out.println("value: " + nums.get(i));
        }
        /* .forEach()方法对每个元素遍历进行操作
        *   .forEach()方法使用一个Lambda表达式作为参数，这个Lambda表达式实际上是一个Consumer接口的实例
        *   Consumer<Integer> print = n -> System.out.println(n);
        *   nums.forEach(print);
        */
        nums.forEach(n -> System.out.println(n));

        // Example 1.1 
        List<CarInfo> carsGroup1 = new ArrayList<CarInfo>();
        carsGroup1.add(new CarInfo(2009, "Mazda"));
        carsGroup1.add(new CarInfo(2019, "Audi"));
        carsGroup1.add(new CarInfo(2016, "Subaru"));

        carsGroup1.forEach(car -> car.print_info());

        

        // Example 2: Set接口(其中的HashSet类) 
        //  Set接口只能支持不重复的元素
        //  其中HashSet输出的元素顺序是随机的，所以也就没有索引的概念 
        Set<Integer> nums2 = new HashSet<Integer>(); // 创建一个HashSet对象 nums2
        nums2.add(129);
        nums2.add(384);
        nums2.add(68);
        nums2.add(19);
        // 使用增强的for循环
        for (Integer num : nums2 ){
            System.out.println("value: " + num);
        }
        // 没有索引的概念，所以我们无法通过索引来获取元素
        // 但是可以只用Iterator迭代器来获取遍历和修改元素,Iterator是一个方法，来自Iterable接口
        // Iterable是Collection接口的父接口，定义了迭代器的基本功能，所以我们可以直接在Collection接口中使用迭代器
        Iterator<Integer> values = nums2.iterator(); // 返回一个迭代器对象
        while (values.hasNext()){ // .hasNext()方法判断是否还有下一个元素
            System.out.println("Value: " + values.next()); // .next()方法获取下一个元素
        }

        // Example 2.1
        Set<CarInfo> carsGroup2 = new HashSet<CarInfo>();
        carsGroup2.add(new CarInfo(2009, "Mazda"));
        carsGroup2.add(new CarInfo(2019, "Audi"));
        carsGroup2.add(new CarInfo(2016, "Subaru"));
        for (CarInfo car : carsGroup2){
            car.print_info();
        }

        Iterator<CarInfo> car = carsGroup2.iterator();
        while (car.hasNext()){
            car.next().print_info();
        }

    }
}   
