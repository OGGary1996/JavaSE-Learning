package training.tutorialAdvanced.c_polymorphism;

public class Student extends Person {
    private String studentId;
    public Student(){
        super();
    }
    public Student(String name, int age, char gender , String studentId) {
        super(name,age,gender);
        this.studentId = studentId;
    }

    @Override
    protected void printInfo() {
        super.printInfo();
        System.out.println("Student ID: " + this.studentId);
    }

    public void compliant() {
        System.out.println("Student " + this.getName() + " is complaining about assignments.");
    }
}
