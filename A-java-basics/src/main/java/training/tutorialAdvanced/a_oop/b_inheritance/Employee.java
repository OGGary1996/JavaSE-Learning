package training.tutorialAdvanced.a_oop.b_inheritance;

// 作为父类

public class Employee {
    protected String id;
    protected String name;
    protected int salary;

    public Employee(){
        this("000000","NULL",0); // 调用有参构造器
    }

    public Employee(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    protected void work() {
        System.out.println("Employee: " + this.id + "->" + this.name + " is working");
    }
    protected void eat() {
        System.out.println("Employee: " + this.id + "->" + this.name + " is eating");
    }
}
