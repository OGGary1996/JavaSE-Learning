package training.tutorialAdvanced.c_polymorphism;

public class Teacher extends Person {
    private String teacherId;
    public Teacher() {
        super();
    }

    public Teacher(String name, int age,char gender, String teacherId) {
        super(name, age,gender);
        this.teacherId = teacherId;
    }

    @Override
    protected void printInfo() {
        super.printInfo();
        System.out.println("Teacher ID: " + this.teacherId);
    }

    public void compliant() {
        System.out.println("Teacher " + this.getName() + " is complaining about salary.");
    }
}
