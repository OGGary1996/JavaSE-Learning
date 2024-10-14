package training;
// 为了保留原始的parent class，并且创建child class时不用重写代码，所以我们使用inheritance
// 任何子类对象都可以被看作是其父类对象的实例，这是因为子类继承了父类的所有特性（字段和方法）。因此，可以使用父类类型的引用变量来指向子类对象。
// single level

import training.exampleclass.Animal;
import training.exampleclass.Cat;
import training.exampleclass.Dog;

public class n_Inheritance_single_level {
    public static void main(String[] args){
        Animal AAA = new Animal();
        AAA.animalName = "AAA";
        AAA.eat(); // 调用parent class的方法
        
        Dog BBB = new Dog();
        BBB.animalName = "BBB";
        BBB.eat();  // 调用从parent class继承的 原始 方法
        BBB.bark(); // 调用child class中扩展 的 新方法

        Animal CCC = new Cat(); // 引用parent class但指向了child class
        CCC.animalName = "CCC";
        CCC.eat(); // 输出的结果为child class中被 重写 的方法
        // 也可以再次调用重写之前的方法
        AAA.eat(); // 这里根据引用的class不同，不同的object对同一个方法产生了不同的行为（多态）
    }
} 
