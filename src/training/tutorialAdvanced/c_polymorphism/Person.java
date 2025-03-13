package training.tutorialAdvanced.c_polymorphism;

public class Person {
    private String name = "Default Name";
    private int age = 0;
    private char gender = 'M';

    public Person(){};
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    protected void printInfo(){
        System.out.println("Name: " + this.name + "\n" + "Age: " + this.age + "\n" + "Gender: " + this.gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
