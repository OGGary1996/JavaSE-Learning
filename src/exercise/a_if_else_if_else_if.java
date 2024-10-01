package exercise;

public class a_if_else_if_else_if {

	public static void main(String[] args) {

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
	}

}
