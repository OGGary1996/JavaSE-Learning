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

public class f_class_object {

	public static void main(String[] args) {

		// 调用calculator
		calculators addnums = new calculators();
		System.out.println(addnums.add(3,5));
		//
		car_info ZK = new car_info (2016,"Subaru");
		ZK.print_info();
	}

}
