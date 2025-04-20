package Reflection.d_getField;

import java.lang.reflect.Field;

class User{
    public String name;
    private int age;
    private char gender;
    // 一共三种构造器
    private User(){
    }
    protected User(String name, int age){
        this.name = name;
        this.age = age;
    }
    public User(String name, int age, char gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

public class a_getField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> userClass = Class.forName("Reflection.d_getField.User");

        // 类似于获取构造器,获取字段也有4种方法，分为2类
        // 1.第一类：获取到所有的字段
            // 1.1 获取所有的public字段
        Field[] publicFields = userClass.getFields();
        for(Field f: publicFields){
            System.out.println("Public field: " + f);
        }
            // 1.2 获取所有的字段
        Field[] allFields = userClass.getDeclaredFields();
        for(Field f: allFields){
            System.out.println("All field: " + f);
        }

        // 2. 第二类：获取指定的字段，与Constructor不一样的是，获取Constructor需要传递的是对应构造器的参数Class对象，字段需要传递字段的名称
            // 2.1 获取public字段
        Field f1 = userClass.getField("name");
        System.out.println("Public field: " + f1);
            // 2.2 获取所有的字段
        Field f2 = userClass.getDeclaredField("age");
        System.out.println("Particular field: " + f2);
    }
}
