package training.tutorialAdvanced.a_oop.f_interface;

public class Frog extends Animal implements Swimming {
    public Frog() {
        super();
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Frog eat insects");
    }

    // 实现父接口和子接口的所有方法
    @Override
    public void breath() {
        System.out.println("Frog breathe through their skin and lungs");
    }
    @Override
    public void sleep() {
        System.out.println("Frog sleep in a curled position");
    }
    @Override
    public void swim() {
        System.out.println("Frog can swim using legs");
    }
}
