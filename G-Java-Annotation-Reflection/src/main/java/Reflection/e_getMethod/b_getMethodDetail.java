package Reflection.e_getMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class b_getMethodDetail {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> userClass = Class.forName("Reflection.e_getMethod.User");
        Method toStringMethod = userClass.getDeclaredMethod("toString");

        // 1. 获取方法的名称
        System.out.println("Name of thr method: " + toStringMethod.getName());
        // 2. 获取方法的修饰符
        int modifier = toStringMethod.getModifiers();
        System.out.println("Modifier of the method: " + Modifier.toString(modifier));
        // 3.获取返回值的类型，这个方法返回的是返回值的Class对象
        Class<?> returnType = toStringMethod.getReturnType();
        System.out.println("Return type of the method: " + returnType.getSimpleName());
        // 4. 获取方法的参数类型,类似于Constructor，返回的是一个Class对象的数组
        Class<?>[] parameterTypes = toStringMethod.getParameterTypes();
        System.out.print("Parameter types of the method: " + Arrays.toString(parameterTypes));
        // 5. 获取方法的异常类型,类似于Constructor，返回的是一个Class对象的数组
        Class<?>[] exceptionTypes = toStringMethod.getExceptionTypes();
        System.out.println("Exception types of the method: " + Arrays.toString(exceptionTypes));
    }
}
