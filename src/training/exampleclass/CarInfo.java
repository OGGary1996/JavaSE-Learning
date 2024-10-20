package training.exampleclass;

public class CarInfo {
	int year;
	String brand;
	public CarInfo(int year,String brand){
		this.year = year;
		this.brand = brand;
	}
	public void print_info() {
		System.out.println("year: "+year+", brand: "+brand+".");
	}
}
