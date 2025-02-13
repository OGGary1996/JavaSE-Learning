package Reflection.a_loadAndInitial;

// 本例子模拟展示类的主动和被动初始化
/*
 主动引用（会发生类的初始化）：
    1. new 一个类的实例
    2. 通过反射创建类的Class对象
 被动引用（不发生类的初始化）：
    1. 访问类的静态字段，和final常量
    2. 通过类的对象数组创建数组
 */

public class ClassInitialDemo2 {
    static{
        System.out.println("Main Class is initialized");
    }
    public static void main(String[] args) {
        // 主动引用：
        // 1. new 一个类的实例
        //Son sonOBJ = new Son(); // 引用了子类，此时会初始化父类和子类
        // 2. 通过反射创建类的Class对象
        //Class sonClass = Son.class; // 引用了子类，此时会初始化父类和子类

        // 被动引用：
        // 1. 通过子类来引用父类中的静态字段，不会导致子类的初始化
        //System.out.println(Son.x); // 此时只会初始化Father类
        // 2. 通过数组定义来引用类，不会触发此类的初始化
        //Son[] sons = new Son[5]; // 此时不会初始化Father类和Son类
    }
}

class Father {
    static int x = 100;
    static {
        System.out.println("Father Class is initialized");
    }
}

class Son extends Father{
    static {
        System.out.println("Son Class is initialized");
        m = 200;
    }
    static int m = 300;
    static final int i = 500;
}