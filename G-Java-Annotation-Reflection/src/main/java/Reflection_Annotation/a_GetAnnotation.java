package Reflection_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// 创建注解
// 1. 创建CLass的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableAnnotation{
    String description() default "Table";
    int version();
}

// 2. 创建方法的注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface AutoRun{
    String value() default "AutoRun";
}

// 3. 创建字段的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColumnAnnotation{
    String name();
    String type();
    int length();
}

//创建JavaBean
@TableAnnotation(description = "Student Table",version = 1)
class Student{
    @ColumnAnnotation(name = "name",type = "String",length = 20)
    private String name;
    @ColumnAnnotation(name = "age",type = "int",length = 2)
    private int age;
    @ColumnAnnotation(name = "id",type = "int",length = 10)
    private static int id = 0;
    private Student(){}
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @AutoRun
    private void autoIncrement(){
        id++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

public class a_GetAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        // 1. 获取类的注解
        Class<?> stuClass = Class.forName("Reflection_Annotation.Student");
            // 1.1 判断注解是否存在
        if (stuClass.isAnnotationPresent(TableAnnotation.class)){
            // 1.2 获取注解
            TableAnnotation tableAnnotation = stuClass.getAnnotation(TableAnnotation.class);
            // 1.3 获取注解的属性值
            System.out.println("TableAnnotation: " + tableAnnotation.description() + ", version: " + tableAnnotation.version());
        }

        // 2. 获取字段的注解
            // 2.1 获取所有的字段
        Field[] declaredFields = stuClass.getDeclaredFields();
            // 2.2 遍历所有的字段
        for (Field f : declaredFields){
            if (!Modifier.toString(f.getModifiers()).equals("public")){
                f.setAccessible(true); // 设置私有属性可访问
            }
            // 2.3 判断字段是否有注解
            if (f.isAnnotationPresent(ColumnAnnotation.class)){
                ColumnAnnotation annotation = f.getAnnotation(ColumnAnnotation.class);
                System.out.println("Field: " + f.getName() + ", name: " + annotation.name() + ", type: " + annotation.type() + ", length: " + annotation.length());
            }
        }

        // 3. 根据方法的注解来执行方法
        // 例如：在创建对象时，自动执行@AutoRun注解的方法
            // 3.1 首先创建对象
        Student stu = new Student("Kevin", 20);
            // 3.2 创建对象之后，此时需要自动执行@AutoRun注解的方法
            // 获取所有的方法
        Method[] allMethods = stu.getClass().getDeclaredMethods();
            // 遍历所有的方法
        for (Method m : allMethods){
            if (!Modifier.toString(m.getModifiers()).equals("public")){
                m.setAccessible(true);
            }
            if (m.isAnnotationPresent(AutoRun.class)){
                m.invoke(stu); // 执行方法
            }
        }

            // 3.3 验证结果
        System.out.println(stu.toString());
    }
}
