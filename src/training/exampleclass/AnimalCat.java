package training.exampleclass;

public class AnimalCat extends Animal { // 创建另一child class，并继承parent class的属性和成员变量

    public AnimalCat(String animalName){
        super(animalName); // 调用parent class的constructor
    }

    public void behave(){ // child class中的新方法
        System.out.println("Cat scratches");
    }

    @Override
    public void eat(){ // 重写parent class的方法
        System.out.println("Cat eats fish");
    }

    @Override
    public void sound(){
        System.out.println("cat meows");
    }
}
