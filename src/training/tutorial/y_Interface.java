package training.tutorial;
// interface是一个抽象类，不能被实例化，只能被实现，用于定义一组方法的接口，接口中的方法都是抽象方法，不能有方法体，不能有静态方法，不能有静态成员，不能有构造方法
// 与abstract class的区别是：1. abstract class可以有构造函数，interface不能有构造函数；
//                         2. abstract class可以有非抽象方法，interface只能有抽象方法；
//                         3. interface中的方法默认是public abstract的，变量默认是public static final的 
//                         4. abstract class本质上还是属于class，不能被多重继承，但是对于interface，多个interface可以被一个类实现。

import training.exampleclass.AnimalDuck;

public class y_Interface {
    public static void main(String[] args){
        AnimalDuck duck1 = new AnimalDuck();
        duck1.fly();
        duck1.swim();

    }
}
