package Reflection.c_getConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class b_getConstructorDetail {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 获取Class对象
        Class<?> userClass = Class.forName("Reflection.c_getConstructor.User");
        // 获取构造器
        Constructor<?> publicConstructor = userClass.getDeclaredConstructor(String.class,int.class,int.class);

        // 1. 获取构造器的全限定名，包含了修饰符、全类名、参数类型、异常等信息
        System.out.println("Constructor Name: " + publicConstructor);

        // 2. 获取修饰符
        int modifier = publicConstructor.getModifiers();
        System.out.println("Modifier: " + Modifier.toString(modifier));

        // 3. 获取参数类型,返回值为形参的Class对象组成的数组
        Class<?>[] parameterTypes = publicConstructor.getParameterTypes();
        for (Class<?> parameterType : parameterTypes){
            System.out.println("Parameter type: " + parameterType.getSimpleName());
        }
        // 4.获取参数个数
        int ParameterCount = publicConstructor.getParameterCount();
        System.out.println("Parameter count: " + ParameterCount);

        // 5. 获取异常类型,返回值为异常的Class对象组成的数组,本例子的构造器不会抛出异常
        Class<?>[] exceptionTypes = publicConstructor.getExceptionTypes();
        for (Class<?> exceptionType : exceptionTypes){
            System.out.println("Exception type: " + exceptionType.getSimpleName());
        }

    }
}
