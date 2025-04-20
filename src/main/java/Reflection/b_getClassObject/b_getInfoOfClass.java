package Reflection.b_getClassObject;

// 本例子展示在获取到Class对象后，如何获取类的基本信息

public class b_getInfoOfClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 获取Class对象，本例子以String类为例
        Class<?> stringClass = Class.forName("java.lang.String");
        // 获取类的名字，包括简单名，规范名，和包名
        System.out.println("====================获取类的名称==========================");
        System.out.println("Full name of class: " + stringClass.getName());
        System.out.println("Simple name of class: " + stringClass.getSimpleName());
        System.out.println("Package of class: " + stringClass.getPackageName());

        // 获取类的父类
        System.out.println("====================获取父类=============================");
        System.out.println("Super class: " + stringClass.getSuperclass().getName());


        //获取类的实现接口，例如ArrayList类实现了List接口,HashMap类实现了Map接口
        System.out.println("====================获取实现接口===========================");
        Class<?> arrayListClass = Class.forName("java.util.ArrayList");
        Class<?>[] interfaces = arrayListClass.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println("Implement Interface: " + i.getName());
        }

        // 判断类的类型(基本数据类型，数组，接口，枚举类)
        System.out.println("====================判断类的类型===========================");
        System.out.println(arrayListClass.isPrimitive());
        System.out.println(arrayListClass.isArray());
        System.out.println(arrayListClass.isEnum());
        System.out.println(arrayListClass.isInterface());
    }
}
