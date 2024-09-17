package exercise;

public class for_loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// for loop
		for(int i = 1 ; i <= 10 ; i ++) {
			System.out.println(i);
		}
		for (int i = 10 ; i >= 1 ; i -=2 ) {
			System.out.println(i);
		}
		//exercise1 
		int sum = 0;
		for (int i = 1 ; i <= 10 ; i++) {
			sum = sum + i;
		}
		System.out.println("sum = "+sum);
		
		
		// nested for loop
		for (int i = 1 ; i <= 10 ; i ++) {
			for (int j = 1 ; j <= 5 ; j++ ){
				System.out.println(j);
			}
			System.out.println("All ieration of j are done for "+i+" ieration of i");
		}
		
		// assignment 3
		//no.1 
		int sum_of_even = 0;
		for (int i = 1 ; i <= 100 ; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.print("The sum of all even number is "+sum_of_even);
		
		//no.2
		int num_a = 0 , num_b = 1;
		System.out.println("The Fibonacci numbers are: "+num_a + " , " + num_b);
		for (int i = 1 ; i <= 18 ; i++ ) {
			int num_c = num_a + num_b;
			System.out.print(num_c+" , ");	
			num_a = num_b;
			num_b = num_c;
		}
		
		// no.3
		System.out.println();
		for (int x = 1 ; x <= 6; x++) {
			for (int y = 1 ; y <= (x+1) ; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
