package b_Meta_Annotation;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyAnnotation4 {
    String value();
}

@MyAnnotation4("Hello, this is Annotation4!")
class test03{
}

public class d_Inherited extends test03{
    public static void main(String[] args) {
        // 获取类上的注解
        MyAnnotation4 annotation = d_Inherited.class.getAnnotation(MyAnnotation4.class);
        System.out.println(annotation.value());
    }
}
