package training;
// 为了保留原始的parent class，并且创建child class时不用重写代码，所以我们使用inheritance
// single level

class Animal{ // 创建一个parent class
    String animalName;
    public void eat(){
        System.out.println(animalName + " is eating.");
    }
}

class Dog extends Animal{ // 创建child class，并继承parent class的属性和成员变量
    public void bark(){
        System.out.println(animalName + " is barking"); // 继承了parent class 的成员变量,并且 扩展 其他 方法。
    }
}

class Cat extends Animal{ // 创建另一child class，并继承parent class的属性和成员变量
    @Override
    public void eat(){ // 直接采用了parent class中的method名称 即重写该方法
        super.eat(); // 使用super关键字 使得原始的方法虽然经过重写 但是还是可以被调用，这个super表示parent class
        System.out.println(animalName + " is eating dog's food!"); // 重写该方法
    }
}

public class n_Inheritance_single_level {
    public static void main(String[] args){
        Animal AAA = new Animal();
        AAA.animalName = "AAA";
        AAA.eat(); // 调用parent class的方法
        
        Dog BBB = new Dog();
        BBB.animalName = "BBB";
        BBB.eat();  // 调用从parent class继承的 原始 方法
        BBB.bark(); // 调用child class中扩展 的 新方法

        Cat CCC = new Cat();
        CCC.animalName = "CCC";
        CCC.eat(); // 输出的结果为child class中被 重写 的 方法
        // 也可以再次调用重写之前的方法 使用super关键字
        
    }
} 
