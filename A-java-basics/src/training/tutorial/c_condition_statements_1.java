package training.tutorial;

public class c_condition_statements_1 {

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
		// exercise 1
		int marks = 86;
		if (marks >= 90) {
			System.out.println("A Grade!");
		}
		if (marks < 90 && marks >= 75) {
			System.out.println("B Grade!");
		}
		if (marks < 75 && marks >= 60) {
			System.out.println("C Grade!");
		}
		if (marks < 60 && marks >=40) {
			System.out.println("D Grade!");
		}
		if (marks < 40) {
			System.out.println("F Grade!");
		}
		//exercise 2
		int marks2 = 36;
		if (marks2 >= 90) {
			System.out.println("A Grade!");
		}
		else if (marks2 >= 75) {
			System.out.println("B Grade!");
		}
		else if (marks2 >= 60) {
			System.out.println("C Grade!");
		}
		else if (marks2 >=40) {
			System.out.println("D Grade!");
		}
		else {
			System.out.println("sorry, you did not pass.");
		}
		// assignment 1
		int num1 = 100, num2 = 400, num3 = 200;
		if (num1 > num2) {
			if (num1 > num3) {
				System.out.println("The biggest number is " + num1);
			}
			else {
				System.out.println("The biggest number is " + num3);
			}
		}
		else {
			if (num2 > num3) {
				System.out.println("The biggest number is " + num2);
			}
			else {
				System.out.println("The biggest number is " + num3);
			}
		}

		int num4 = 100;
		int num5 = 400;
		int num6 = 200;
		if (num4 > num5 && num4 > num6){
			System.out.println("num4 is the biggest number.");
		}
		else if (num5 > num4 && num5 > num6){
			System.out.println("num5 is the biggest number.");
		}
		else {
			System.out.println("num6 is the biggest number.");
		}
	}

}
