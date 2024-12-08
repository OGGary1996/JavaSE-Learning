package training.tutorial;
// 为了保留原始的parent class，并且创建child class时不用重写代码，所以我们使用inheritance
// 任何子类对象都可以被看作是其父类对象的实例，这是因为子类继承了父类的所有特性（字段和方法）。因此，可以使用父类类型的引用变量来指向子类对象。
// single level

import training.tutorial.exampleclass.Animal;
import training.tutorial.exampleclass.AnimalCat;
import training.tutorial.exampleclass.AnimalDog;

public class l_Inheritance1_single_level {
    public static void main(String[] args){
        Animal Animal1 = new Animal("Animal1");
        Animal1.eat(); // 调用parent class的方法 但是无法调用child class中的方法
        
        AnimalDog Dog1 = new AnimalDog("Dog1");

        Dog1.sleep();  // 调用从parent class继承的方法
        Dog1.eat(); // 调用child class中重写的方法
        Dog1.behave(); // 调用child class中扩展 的 新方法

        Animal Cat1 = new AnimalCat("Cat1"); // 引用parent class但指向了child class的object
        Cat1.eat(); // 输出的结果为child class中被 重写 的方法
        // 也可以再次调用重写之前的方法
        Animal1.eat(); // 这里根据引用的class不同，不同的object对同一个方法产生了不同的行为（多态）
    }
} 
