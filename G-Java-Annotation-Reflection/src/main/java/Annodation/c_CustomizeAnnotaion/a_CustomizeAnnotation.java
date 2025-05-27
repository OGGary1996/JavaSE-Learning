package Annodation.c_CustomizeAnnotaion;

import java.lang.annotation.*;

// 自定义一个多个参数的注解
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyCustomizedAnnotation{
    String name();
    int age();
    String[] description();
}

@MyCustomizedAnnotation(name = "Tom",age = 18 , description = {"Saskatoon","Canada"})
public class a_CustomizeAnnotation {
    @MyCustomizedAnnotation(name = "Jerry",age = 20, description = {"Regina","Canada"})
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
