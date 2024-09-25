package training;

public class calculator{
	public int add(int num1, int num2) {
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