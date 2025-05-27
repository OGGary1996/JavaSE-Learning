package Reflection.c_getConstructor;

import java.lang.reflect.Constructor;

class User{
    private String name;
    private int id;
    private int age;
    // 一共三种构造器
    private User(){
    }
    protected User(String name, int id){
        this.name = name;
        this.id = id;
    }
    public User(String name, int id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        System.out.println("Name: " + name + ", ID: " + id + ", Age: " + age);
        return null;
    }
}

public class a_getConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 获取Class对象
        Class<?> userClass = Class.forName("Reflection.c_getConstructor.User");

        // 获取构造器一共有四种方法,分为两大类
        // 1. 第一类，获取到一组构造器，返回值为Constructor<?>[]
            // 1.1 获取public构造器
        Constructor<?>[] publicConstructors = userClass.getConstructors();
        for(Constructor<?> publicConstructor : publicConstructors){
            System.out.println("Public Constructor: " + publicConstructor);
            // 打印的结果包含了修饰符、全类名、参数类型、异常等信息
        }
            // 1.2 获取所有构造器,包括private和protected
        Constructor<?>[] allConstructors = userClass.getDeclaredConstructors();
        for(Constructor<?> constructor : allConstructors){
            System.out.println("All Constructor: " + constructor);
        }

        // 2.第二类，获取单个构造器，需要传递构造器形餐的Class对象,返回值为Constructor<?>
            // 2.1 获取public构造器
        Constructor<?> publicConstructor = userClass.getConstructor(String.class,int.class,int.class);
        System.out.println("Public Constructor: " + publicConstructor);
            // 2.2 获取所有构造器,包括private和protected,同样可以获取上一步获取的public构造器
        Constructor<?> publicConstructor2 = userClass.getDeclaredConstructor(String.class,int.class,int.class);
        System.out.println("Public Constructor: " + publicConstructor2);
        Constructor<?> defaultConstructor = userClass.getDeclaredConstructor(); // 空构造器
        System.out.println("Default Constructor: " + defaultConstructor);
        Constructor<?> protectedConstructor = userClass.getDeclaredConstructor(String.class,int.class); // 受保护的构造器
        System.out.println("Protected Constructor: " + protectedConstructor);

    }
}
