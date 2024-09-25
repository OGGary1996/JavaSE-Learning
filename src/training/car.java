package training;

public class car {
	int year;
	String brand;
	
	car(int year, String brand){
		this.year = year;
		this.brand = brand;
	}
	
	public void printinfo() {
		System.out.println("Brand: " + this.brand + ", Year: " + this.year);
	}
}
