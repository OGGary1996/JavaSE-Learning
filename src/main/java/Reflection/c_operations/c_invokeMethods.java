package Reflection.c_operations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class c_invokeMethods {
    public static void main(String[] args) throws Exception {
        // 1. 获取Class对象，并且创建对象
        Class<?> personClass = Person.class;
        Object person = personClass.getDeclaredConstructor().newInstance();
        // 2.注入字段
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            if (field.getName().equals("name")){
                field.set(person,"Ke");
            }else if (field.getName().equals("age")){
                field.set(person,24);
            }else if (field.getName().equals("isMarried")){
                field.set(person,false);
            }
        }

        // 3.获取方法并调用
        Method[] allMethods = personClass.getDeclaredMethods();
        for (Method method : allMethods){
            method.setAccessible(true);
            if (method.getName().equals("setAge")){
                method.invoke(person,28);
            }else if (method.getName().equals("setMarried")){
                method.invoke(person,true);
            }
        }
        personClass.getDeclaredMethod("toString",null).invoke(person);

    }
}
