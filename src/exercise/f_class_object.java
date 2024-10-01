package exercise;

class Employees{
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

class methods{
    int resultadd;
    int resultmulti;
    public int addition(int a , int b){
        resultadd = a + b + resultadd; // 用于保存计算结果
        return resultadd;
    }

    public int addition(int a){ // method overload,overload可以是变量个数不同，数据类型不同，或者变量个数和数据类型都不同
        resultadd = a + resultadd; // 用于保存计算结果
        return resultadd;
    }

    public int multiply(int a , int b ){
        resultmulti = a * b * resultmulti; // 用于保存计算结果
        return resultmulti;
    }

    public int multiply(int a){
        resultmulti = a * resultmulti; // 用于保存计算结果
        return resultmulti;
    }
}


public class f_class_object {
    public static void main(String[] args){
    Employees emp1 = new Employees("ke",1,8356.7);
    emp1.print_bonus();

    methods calculate1 = new methods();
    System.out.println(calculate1.addition(3,5)); // resultadd等于3+5=8
    System.out.println(calculate1.addition(2)); // resultadd等于前一步的结果8+2
    System.out.println(calculate1.multiply(2,5)); 

    }
}
