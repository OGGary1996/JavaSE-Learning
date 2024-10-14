package training.exampleclass;

public class Employees {
    String Employee_name;
    int Employee_id;
    double Employee_salary;

    public Employees(String Employee_name , int Employee_id , double Employee_salary){
        this.Employee_name = Employee_name;
        this.Employee_id = Employee_id;
        this.Employee_salary = Employee_salary;
    } 

    public void print_bonus(){
        System.out.println("Name: "+Employee_name);
        System.out.println("ID: "+Employee_id);
        System.out.println("Salary: "+Employee_salary);
        System.out.println("Bonus is 20% of salary: "+Employee_salary*0.2);       
    }
}
