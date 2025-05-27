package training.tutorialAdvanced.a_oop.e_abstract;

public class Teacher extends Person {
    public Teacher() {
        super();
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("Teacher is teaching");
    }
}
