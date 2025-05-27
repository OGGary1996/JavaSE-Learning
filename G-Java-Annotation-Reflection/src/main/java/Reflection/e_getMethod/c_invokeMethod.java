package Reflection.e_getMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class c_invokeMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> userClass = Class.forName("Reflection.e_getMethod.User");
        // 1. 调用静态方法，且静态方法是private的
            // 1.1 获取方法
        Method initialize = userClass.getDeclaredMethod("initialize");
            // 1.2 设置权限
        initialize.setAccessible(true);
            // 1.3 调用方法,调用静态方法时，对象参数传递null
        initialize.invoke(null);

        // 2. 调用对象方法
            // 2.1 创建对象
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(String.class, int.class, char.class);
        User user = (User)declaredConstructor.newInstance("Gary", 18, 'M');
            // 2.2 获取方法
        Method getNameMethod = userClass.getDeclaredMethod("getName");
            // 2.3 调用方法
        String name = (String) getNameMethod.invoke(user);
        System.out.println("Name of the user: " + name);

    }
}
