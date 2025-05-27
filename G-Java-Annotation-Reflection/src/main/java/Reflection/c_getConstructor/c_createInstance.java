package Reflection.c_getConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class c_createInstance {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取Class对象
        Class<?> userClass = Class.forName("Reflection.c_getConstructor.User");

        // 通过获取的构造器创建实例
        // 1. 通过public构造器创建实例
        Constructor<?> publicConstructor = userClass.getDeclaredConstructor(String.class,int.class,int.class);
        User user1 = (User) publicConstructor.newInstance("Gary", 1, 25);
        // 2. 通过private构造器创建实例之前，必须要设置访问权限
        Constructor<?> privateConstructor = userClass.getDeclaredConstructor();
        privateConstructor.setAccessible(true);
        User user2 = (User) privateConstructor.newInstance();

        // Example: 获取到所有的Constructor，并且自动根据修饰符和参数类型创建实例
        Constructor<?>[] allConstructors = userClass.getDeclaredConstructors();
        // 创建集合接收所有创建的实例
        List<User> userList = new ArrayList<User>();
        for (Constructor<?> con : allConstructors){
            // 获取修饰符和参数类型
            String modifier = Modifier.toString(con.getModifiers());
            Class<?>[] parameterTypes = con.getParameterTypes();
            if (!modifier.equals("public")){ // 如果非public
                con.setAccessible(true);
            }
            // 根据参数类型Class对象数组，将所有的参数收集到Objet对象数组中
            Object[] parameters = new Object[parameterTypes.length];
            for (int i = 0 ; i < parameterTypes.length ; i++){
                if (parameterTypes[i] == String.class){
                    parameters[i] = "TestString";
                } else if (parameterTypes[i] == int.class){
                    parameters[i] = 1;
                } else if (parameterTypes[i] == double.class){
                    parameters[i] = 1.0;
                } else {
                    parameters[i] = null; // 如果参数类型不在预设范围内，设置为null
                }
            }
            // 创建实例时，参数是可变参数类型，而可变参数类型实际上是一个数组
            // 所以我们可以直接把Object对象数组传入
            userList.add((User)con.newInstance(parameters));
        }

        // 打印所有创建的实例
        userList.forEach(System.out::println);
    }
}
