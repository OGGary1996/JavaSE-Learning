package training.tutorialAdvanced.e_abstract;

public class Student extends Person {
    public Student(){
        super();
    }
    public Student(String name, int age){
        super(name,age);
    }

    @Override
    public void work() {
        System.out.println("Student is studying");
    }
}
