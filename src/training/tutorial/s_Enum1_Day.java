package training.tutorial;

import training.exampleenum.Day;
import java.sql.*;

// Enum是一种特殊的数据类型，用于定义常量
// Enum也是一种class，但是它有一些特殊的特性，比如不能被继承，不能创建实例，不能被扩展
// Enum本身继承自java.lang.Enum类
// 使用Enum就不用再使用public static final来定义一些固定的常量，直接使用enum定义即可
public class s_Enum1_Day {
    public static void main(String[] args) {
        // 直接调用Day 枚举类中的object元素,不需要再创建new object
        Day day = Day.MONDAY;
        System.out.println(day);
        // Enums继承自java.lang.Enum类
        System.out.println(day.getClass().getSuperclass());

        Day toDay = Day.SATURDAY;
        switch(toDay){
            case SATURDAY:
                System.out.println("Today is weenkend");
                break;
            case SUNDAY:
                System.out.println("Today is weenkend");
                break;
            default:
                System.out.println("Today is workday");
                break;
        }
        switch(toDay){
            case SATURDAY -> System.out.println("Today is weenkend");
            case SUNDAY -> System.out.println("Today is weenkend");
            default -> System.out.println("Today is workday");
        }

        // 每一个枚举类中的object都有index属性，可以通过ordinal()方法获取
        System.out.println(day.ordinal()); // 从0开始
        // 每一个枚举类中的object都有name属性，可以通过name()方法获取
        System.out.println(toDay.name());
        // 可以一次调用多个object 通过使用values()方法，返回一个包含所有object的Array,(对象数组)
        Day[] days = Day.values();
        for(Day d : days){
            System.out.println(d + ", at index: " + d.ordinal());
        }

        
 // 使用枚举类中的方法
        System.out.println(day.getDescriptiopn());
        System.out.println(toDay.getDescriptiopn());

    }
}
