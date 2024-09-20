package training;

public class car 
{
	int year;
	String model;
	
	car (int y , String m) 
	{
		year = y;
		model = m;
	}
	void print_car_info() 
	{
		System.out.println("year:" + year + ", model: " +model);
	}
}
