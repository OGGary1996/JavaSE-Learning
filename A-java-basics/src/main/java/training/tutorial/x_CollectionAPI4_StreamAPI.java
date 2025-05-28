package training.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import training.tutorial.exampleClass.CarInfo;

// Stream API: 用于对集合进行复杂的操作，如筛选、排序、过滤等。
public class x_CollectionAPI4_StreamAPI {
    public static void main(String args[]){
        // Stream 的使用步骤：
        //Example 1: 使用Stream API对集合进行操作
        // 1. 创建一个集合，对集合调用.stream()方法，这个方法返回一个Stream对象
        // 这个Stream对象包含了集合中的所有元素，针对这个Stream对象进行的修改不会影响原集合
        List<CarInfo> carsGroup1 = new ArrayList<>();
        carsGroup1.add(new CarInfo(2009,  "Mazda"));
        carsGroup1.add(new CarInfo(2019, "Audi"));
        carsGroup1.add(new CarInfo(2016, "Subaru"));
        Stream<CarInfo> carsStream1 = carsGroup1.stream(); 
        // 2. 使用Stream对象的方法对集合进行操作，当前的Stream对象只能被使用一次
        // 2.1 使用.filter()方法筛选出符合条件的元素,返回另外一个Stream对象
        Stream<CarInfo> carsStream2 = carsStream1.filter(car -> car.getYear() > 2013 );
            // .filter()方法的参数是一个Lambda表达式，这个Lambda表达式实际上是一个Predicate接口的实例
            // Predicate<CarInfo> filter = car -> car.getYear() > 2013;
            // Stream<CarInfo> carsStream2 = carsStream1.filter(filter);
        
        // 2.2 使用.map()方法对元素进行内存地址重新引用，返回另外一个Stream对象
        Stream<CarInfo> carsStream3 = carsStream2.map(car -> new CarInfo(car.getYear(), car.getBrand().toUpperCase()));
            // .map()方法的参数是一个Lambda表达式，这个Lambda表达式实际上是一个Function接口的实例
            // Function<CarInfo, CarInfo> map = car -> new CarInfo(car.getYear(), car.getBrand().toUpperCase());
            // Stream<CarInfo> carsStream3 = carsStream2.map(map);
        // 2.3 使用.forEach()方法对每个元素进行操作
        carsStream3.forEach(car -> car.print_info());


        //Example 2
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // 创建一个List对象 
        Stream<Integer> numsStream1 = nums.stream().filter(n -> n % 2 == 0).map(n -> n * 2); // 使用Stream对象的方法对集合进行操作
        // 使用.reduce()方法对Stream对象中的元素进行操作, 返回一个Optional对象
        int result = numsStream1.reduce(0, (a,b) -> a + b); 
        System.out.println(result);
            
    }
}
