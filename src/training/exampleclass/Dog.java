package training.exampleclass;

public class Dog extends Animal { // 创建child class，并继承parent class的属性和成员变量
    public void bark(){
        System.out.println(animalName + " is barking"); // 继承了parent class 的成员变量,并且 扩展 其他 方法。
    }

    @Override
    public void sund(){
        System.out.println("Dog barks");
    }
}
