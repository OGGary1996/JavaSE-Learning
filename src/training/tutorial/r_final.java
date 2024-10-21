package training.tutorial;

// final关键字有三个主要的用途，后面+variable/method/class

public class r_final {
    public static void main(String[] args){
    // final + variable
    final int num1 = 8;
    // num1 = 9;    将会报错，使用了final关键字之后，num1不能再被赋值 

    // final + method 这个方法不能再被重写
    //  见AdvancedCalcu class中的方法

    // final + class 这个class不能被继承
    //  见VeryAdvancedCalcu class

    }
}
