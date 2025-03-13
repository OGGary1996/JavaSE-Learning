package training.tutorialAdvanced.f_interface;

public class Dog extends Animal implements Swimming {
    public Dog(){
        super();
    }
    public Dog(String name, int age){
        super(name,age);
    }

    @Override
    public void eat(){
        System.out.println("Dog eat meat");
    }

    // 实现父接口和子接口的所有方法
    @Override
    public void breath() {
        System.out.println("Dogs breathe through their noses and mouths");
    }
    @Override
    public void sleep() {
        System.out.println("Dogs sleep in a curled position");
    }
    @Override
    public void swim() {
        System.out.println("Dog can swim using paws");
    }
}
