package training.tutorialAdvanced.a_oop.g_InnerClass;

public class Outer {

    public void show(){
        int a = 10 ;
        class Inner{
            String name;
            int age;
            public void method1(){
                System.out.println("Inner class method1" + a); // 可以访问外部类的成员变量
            }
            public void method2(){
                System.out.println("Inner class method2" + a); // 可以访问外部类的成员变量
            }
        }

        // 需要创建局部内部类的对象才能使用
        Inner inner = new Inner();
        inner.method1();
        inner.method2();

    }
}
