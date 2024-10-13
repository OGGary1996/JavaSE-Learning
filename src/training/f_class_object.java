package training;
class calculators{
	public int add(int num1 , int num2) {
		int result = num1 + num2;
		return result;
	}
	// method overloading 
	public int add(int num1, int num2, int num3) {
		int result = num1 + num2 + num3;
		return result;
	}
	public double add(double num1 , int num2) {
		double result = num1 + num2;
		return result;
	}
	public int time(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}
}

class car_info{
	int year;
	String brand;
	car_info(int year,String brand){
		this.year = year;
		this.brand = brand;
	}
	public void print_info() {
		System.out.println("year: "+year+", brand: "+brand+".");
	}
}

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

public class f_class_object {

	public static void main(String[] args) {

		// 调用calculator
		calculators addnums = new calculators();
		System.out.println(addnums.add(3,5));
		//调用car_info
		car_info ZK = new car_info (2016,"Subaru");
		ZK.print_info();
		
		// 调用employees
	    Employees emp1 = new Employees("ke",1,8356.7);
    	emp1.print_bonus();

	}

}
