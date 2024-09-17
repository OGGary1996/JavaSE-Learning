package training;

public class ternary_operator_switch_statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 使用ternary operator 三元运算符来替代单个if-else 或者if-else if
		int num1 = 8 ;
		String result = (num1 > 5) ? "greater than 5" : "less than 5";
		System.out.println(result);
		
		// 使用switch statement来替代多个if-else 或者多个if-else if
		// 方法1
		int days = 6;
		switch (days) {
		case 1 :
			System.out.println("Monday");
			break;
		case 2 :
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		default:
			System.out.println("Sunday");
		}
		//方法2
		int x = 5;
		String day_name = switch ( x ) {
		case 1 -> "Monday";
		case 2 -> "Tuesday";
		case 3 -> "wednesday";
		case 4 -> "Thursday";
		case 5 -> "Friday";
		case 6 -> "Saturday";
		case 7 -> "Sunday";
		default -> "invalid day";
		};
		System.out.println(day_name);
	}

}
