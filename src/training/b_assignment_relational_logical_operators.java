package training;

public class b_assignment_relational_logical_operators {

	public static void main(String[] args) {

		// assignment operators
		// 加减乘除余
		int num1 = 7;
		int result1 = num1 % 5;
		System.out.println("result1 = "+result1);
		
		// 自增 自减 自乘 自除
		int num2 = 7;
		int result2 = num2 /= 2;
		System.out.println("result2 = "+result2);
		// 当 自增 自减 自乘 自除为1时
		int num3 = 7;
		int result3 = num3++;
		System.out.println("result3 = "+result3); //结果还是7
		int num4 = 7;
		int result4 = ++num4;
		System.out.println("result4 = "+result4); //结果为8
		// num++，++num 区别在于num1++会先返回num1的值，然后在自增1；++num1会先自增1，然后再返回自增1后的值。
		
		
		// relational operators
		// <(<=) , >(>=) , == ,!= 。=通常表示赋值
		double a = 6.9;
		float b = 7.8f;
		boolean result_1 = a != b;
		boolean result_2 = a >= b;
		System.out.println(result_1);
		System.out.println(result_2);
		
		
		// logical operators
		// And (%) , or (|) , not (!)
		int c = 5, d =8 , x = 9 , y = 10;
		boolean result = c > d || x > y;
		System.out.println(result);
		System.out.println(!result);	
	}

}
