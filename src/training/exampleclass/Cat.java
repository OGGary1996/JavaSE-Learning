package training.exampleclass;

public class Cat extends Animal { // 创建另一child class，并继承parent class的属性和成员变量
    @Override
    public void eat(){ // 直接采用了parent class中的method名称 即重写该方法
        super.eat(); // 使用super关键字 使得原始的方法虽然经过重写 但是还是可以被调用，这个super表示parent class
        System.out.println(animalName + " is eating cat's food!"); // 重写该方法
    }

    @Override
    public void sund(){
        System.out.println("cat meows");
    }
}
