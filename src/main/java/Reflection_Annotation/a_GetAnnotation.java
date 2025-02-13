package Reflection_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 本例子展示如何获取注解，包括类注解，字段注解，方法注解
// 1. 创建自定义注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableAnnotation{
    String value() default "Student Table";
    int version() default 0;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColumnAnnotation{
    String columnName();
    String columnType();
    int columnLength();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface AutoRun {
    String value() default "Method auto run";
}

// 2. 创建类，字段，方法注解
@TableAnnotation(value = "Student Table Template", version = 1)
class Student{
    @ColumnAnnotation(columnName = "id",columnType = "int" , columnLength = 6)
    private int id = 0;
    @ColumnAnnotation(columnName = "name",columnType = "varchar" , columnLength = 20)
    private String name;
    @ColumnAnnotation(columnName = "age",columnType = "int" , columnLength = 2)
    private int age;

    public Student(){}

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @AutoRun("Method auto run")
    public void autoIncrement(){
        id++;
    }

    public String print(){
        System.out.println("Student-> id: " + id + ", name: " + name + ", age: " + age);
        return null;
    }
}

public class a_GetAnnotation {
    public static void main(String[] args) throws Exception {
        // 1.获取类的注解
        Class<?> studentClass = Student.class;
            // 1.1 检测注解是否存在
        if (studentClass.isAnnotationPresent(TableAnnotation.class)){
            // 1.2 获取注解
            TableAnnotation table = studentClass.getAnnotation(TableAnnotation.class);
            System.out.println("Table Name: " + table.value() + ", Table Version: " + table.version());
        }else{
            System.out.println("TableAnnotation not fund");
        }

        // 2.获取字段的注解
            // 2.1 获取所有字段
        Field[] fields = studentClass.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            // 2.2 检查是否存在注解
            if(field.isAnnotationPresent(ColumnAnnotation.class)){
                // 2.3 获取并且打印信息
                ColumnAnnotation column = field.getAnnotation(ColumnAnnotation.class);
                System.out.println("Column Name: " + column.columnName() +
                        ", Column Type: " + column.columnType() +
                        ", Column Length: " + column.columnLength());
            }else{
                System.out.println("ColumnAnnotation not fund");
            }
        }

        // 3.获取方法的注解
            // 3.1 获取所有方法
        Method[] methods = studentClass.getDeclaredMethods();
        for (Method method : methods){
            method.setAccessible(true);
            // 3.2 检查是否存在注解
            if(method.isAnnotationPresent(AutoRun.class)){
                // 3.3 获取并且打印信息
                AutoRun autoRun = method.getAnnotation(AutoRun.class);
                System.out.println("Method Name: " + method.getName() + ", Method Description: " + autoRun.value());
            }else{
                System.out.println("Method Name: " + method.getName() + "@AutoRun not fund");
            }
        }

        // 4 通过解析注解，执行方法
        Object student1 = studentClass.getDeclaredConstructor(String.class,int.class).newInstance("Ke",20);
        Method method1 = studentClass.getDeclaredMethod("autoIncrement");
        if (method1.isAnnotationPresent(AutoRun.class)){
            method1.invoke(student1);
        }
        studentClass.getDeclaredMethod("print").invoke(student1);

    }
}
