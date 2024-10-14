package training.exampleclass;

public class car_info {
	int year;
	String brand;
	public car_info(int year,String brand){
		this.year = year;
		this.brand = brand;
	}
	public void print_info() {
		System.out.println("year: "+year+", brand: "+brand+".");
	}
}
