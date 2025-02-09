package b_Meta_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
}

@MyAnnotation2
public class b_Retention {
    @MyAnnotation2
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
