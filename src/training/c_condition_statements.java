package training;

public class c_condition_statements {

	public static void main(String[] args) {

		// if-else
		int a = 28;
		if (a > 10 && a <= 20) {
			System.out.println("hello");
		}
		else {
			System.out.println("bye");
		}
		
		// if-else if
		// example 比较三个数字大小
		int x = 100 , y = 400 , z = 200;
		if (x > y && x >z) {
			System.out.println(x +" is the Greatest number");
		}
		else if (y > z) {
			System.out.println(y +" is the Greatest number");
		}
		else {
			System.out.print(z +" is the Greatest number");
		}
	}

}
