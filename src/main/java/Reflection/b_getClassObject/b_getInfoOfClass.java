package Reflection.b_getClassObject;

// 本例子展示在获取到Class对象后，如何获取类的基本信息

import java.lang.reflect.*;

public class b_getInfoOfClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 获取Class对象，本例子以String类为例
        Class<?> stringClass = Class.forName("java.lang.String");
        // 获取类的名字，包括简单名，规范名，和包名
        System.out.println("====================获取类的名称==========================");
        System.out.println(stringClass.getName()); // 包名 + 类名
        System.out.println(stringClass.getSimpleName()); // 类名
        System.out.println(stringClass.getPackageName()); // 包名

        // 获取类的父类
        System.out.println("====================获取父类=============================");
        System.out.println(stringClass.getSuperclass().getName());

        //获取类的实现接口，例如ArrayList类实现了List接口,HashMap类实现了Map接口
        System.out.println("====================获取实现接口===========================");
        Class<?> arrayListClass = java.util.ArrayList.class;
        Class<?>[] interfaces = arrayListClass.getInterfaces();
        for (Class<?> i: interfaces){
            System.out.println(i.getName());
        }

        // 判断类的类型(基本数据类型，数组，接口，枚举类)
        System.out.println("====================判断类的类型===========================");
        System.out.println(arrayListClass.isPrimitive());
        System.out.println(arrayListClass.isArray());
        System.out.println(arrayListClass.isEnum());
        System.out.println(arrayListClass.isInterface());

        // 获取类所有的public 构造器,返回的是一个Constructor数组
        System.out.println("====================获取构造器===========================");
        Class<?> UserClass = Class.forName("Reflection.b_getClassObject.User");
        Constructor<?>[] constructors = UserClass.getConstructors();
        for(Constructor<?> constructor : constructors){
            System.out.println(constructor);
        }
        System.out.println();
            // 获取所有的构造期，public + private
        Constructor<?>[] declaredConstructors = UserClass.getDeclaredConstructors();
        for(Constructor<?> constructor : declaredConstructors){
            System.out.println(constructor);
        }
        System.out.println();
            // 获取指定的构造器（已知某一个构造器的情况下）
        Constructor<?> constructor = UserClass.getConstructor(String.class,int.class,int.class);
        System.out.println(constructor);

        // 获取类的所有public方法法，包括继承自Object的Method,返回的是一个Method数组
        System.out.println("====================获取方法==============================");
        Method[] methods = UserClass.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }
        System.out.println();
            // 仅获取当前类的方法，不包括继承的方法
        Method[] declaredMethods = UserClass.getDeclaredMethods();
        for(Method method : declaredMethods){
            System.out.println(method);
        }
            // 获取指定的方法（已知某一个方法的情况下）
        Method getName = UserClass.getDeclaredMethod("getName",null);
        System.out.println(getName);
        Method setName = UserClass.getDeclaredMethod("setName",String.class);
        System.out.println(setName);

        // 获取类的public字段
        System.out.println("====================获取字段==============================");
        Field[] fields = UserClass.getFields();
        for (Field f : fields){
            System.out.println(f);
        }
        System.out.println();
            // 获取类的所有字段，成员变量，包括private的字段和从Object继承的字段，返回的是一个Field数组
        Field[] declaredFields = UserClass.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }
        System.out.println();
            // 获取指定的字段（已知某一个字段的情况下）
        Field filed = UserClass.getDeclaredField("name");
        System.out.println(filed);

        // 判断某个类是否为某个类的子类
        System.out.println("====================判断是否为子类=========================");
        System.out.println(UserClass.isAssignableFrom(Object.class));
        System.out.println(Integer.class.isAssignableFrom(Number.class));
        System.out.println(String.class.isAssignableFrom(Number.class)); // String不是Number的子类,false

    }
}
