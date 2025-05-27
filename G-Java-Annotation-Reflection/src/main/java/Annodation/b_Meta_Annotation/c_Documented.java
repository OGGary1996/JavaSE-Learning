package Annodation.b_Meta_Annotation;

import java.lang.annotation.*;
/*
    this annotation will be documented by javadoc
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    String value();
}

@MyAnnotation3("Hello, document me!")
public class c_Documented {
}
