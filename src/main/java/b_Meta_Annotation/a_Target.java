package b_Meta_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// 定义一个简单的注解，然后使用@Target元注解来指定注解的使用范围
@Target({ElementType.TYPE,ElementType.METHOD}) // 需要传递参数指定注解的使用范围，如@Target(ElementType.METHOD)
@interface MyAnnotation1 {
}

@MyAnnotation1
public class a_Target {
    @MyAnnotation1
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
