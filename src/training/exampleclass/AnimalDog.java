package training.exampleclass;

public class AnimalDog extends Animal { // 创建child class，并继承parent class的属性和成员变量

    public AnimalDog(String animalName){
        super(animalName); // 调用parent class的constructor
    }

    public void behave(){ // child class中的新方法
        System.out.println("Dog bites");
    }
    @Override
    public void eat(){ // 重写parent class的方法
        System.out.println("Dog eats bone");
    }
    @Override
    public void sound(){
        System.out.println("Dog barks");
    }
}
