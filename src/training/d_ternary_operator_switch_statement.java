package training;

public class d_ternary_operator_switch_statement {

	public static void main(String[] args) {

		// 使用ternary operator 三元运算符来替代单个if-else 或者if-else if
		int num1 = 8;
		String result = num1 > 5 ? "Greater than 5" : "Less than 5";
		System.out.println(result);
		
		// 使用switch statement来替代多个if-else 或者多个if-else if
		// 方法1
		int days = 6;
		switch (days) {
		case 1:
			System.out.println("monday");
			break;
		case 2:
			System.out.println("tuesday");
			break;
		case 3:
			System.out.println("wednesday");
			break;
		case 4:
			System.out.println("thursday");
			break;
		case 5:
			System.out.println("friday");
			break;
		case 6:
			System.out.println("saturday");
			break;
		case 7:
			System.out.println("sunday");
			break;
		default:
			System.out.println("invalid input");
		};
		
		//方法2 现版本中switch可以有返回值 
		int x = 5;
		String date = switch ( x ) {
		case 1 -> "monday";
		case 2 -> "tuesday";
		case 3 -> "wednesday";
		case 4 -> "thursday";
		case 5 -> "friday";
		case 6 -> "saturday";
		case 7 -> "sunday";
		default -> "invalid input";
		};
		System.out.println(date);
	}

}
