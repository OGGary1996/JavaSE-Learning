package Reflection.e_getMethod;

import java.lang.reflect.Method;

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
    private static void initialize(){
        System.out.println("Static method initialize");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
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

public class a_getMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> userClass = Class.forName("Reflection.e_getMethod.User");

        // 获取方法有4种方式，分为2类
        // 1. 第一类，获取所有的方法
            // 1.1 获取所有的public方法，注意：获取所有的public方法时，获取到的是父类和子类的所有public方法
        Method[] publicMethods = userClass.getMethods();
        for (Method m : publicMethods){
            System.out.println("Public method: " + m);
        }
            // 1.2 获取所有的方法，包括private；注意：获取到的是本类的所有方法
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println("Declared method: " + m);
        }

        // 2. 第二类，获取指定的方法，传递的参数为方法名称和参数类型的Class对象
            // 2.1 获取指定的public方法
        Method setName = userClass.getMethod("setName", String.class);
            // 2.2 获取指定的private或者public方法
        Method toString = userClass.getMethod("toString");

    }
}
