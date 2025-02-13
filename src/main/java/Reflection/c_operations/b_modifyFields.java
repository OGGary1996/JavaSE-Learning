package Reflection.c_operations;

// 本例子展示如何修改类的字段，包括public, private 字段

import java.lang.reflect.Field;

public class b_modifyFields {
    public static void main(String[] args) throws Exception {
        // 1. 获取Class对象，并创建对象，在之后修改字段需要使用对象
        Class<?> personClass = Person.class;
        Object person1 = personClass.getDeclaredConstructor().newInstance();
        // 2. 获取public字段并修改字段
        Field nameField = personClass.getDeclaredField("name");
        nameField.set(person1,"Ke");
        // 3. 获取Private字段
        Field[] allFields = personClass.getDeclaredFields();
        for (Field field : allFields){
            field.setAccessible(true);
            if (field.getName().equals("age")){
                field.set(person1,28);
            }else if (field.getName().equals("isMarried")){
                field.set(person1,true);
            }
        }
        // 4. 输出字段
        System.out.println(person1);
    }
}
