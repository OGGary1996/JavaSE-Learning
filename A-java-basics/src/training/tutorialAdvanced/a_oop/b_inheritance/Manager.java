package training.tutorialAdvanced.a_oop.b_inheritance;

public class Manager extends Employee {
    int bonus;
    public Manager(){
        super();
    }
    public Manager(String id , String name, int salary, int bonus){
        super(id,name,salary);
        this.bonus = bonus;
    }

//    @Override
//    protected void work() {
//        System.out.println("Manager: " + this.id + "->" + this.name + " is working");
//    }
//    protected void eat() {
//        System.out.println("Manager: " + this.id + "->" + this.name + " is eating");
//    }

    public int getBonus() {
        return this.bonus;
    }
}
