package Reflection.d_getField;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class b_getFieldDetail {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> userClass = Class.forName("Reflection.d_getField.User");
        Field ageField = userClass.getDeclaredField("age");
        // 获取字段之后可以获取到字段的详细信息
        // 1. 获取字段的名称
        System.out.println("Name of the field: " + ageField.getName());

        // 2. 获取字段的修饰符
        int modifier = ageField.getModifiers();
        System.out.println("Modifier of the field: " + Modifier.toString(modifier));

        // 3. 获取字段的类型,返回值为类型的Class对象
        Class<?> fieldType = ageField.getType();
        System.out.println("Type of the field: " + fieldType.getSimpleName());
    }
}
