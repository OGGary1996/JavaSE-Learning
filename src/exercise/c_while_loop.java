package exercise;

public class c_while_loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//while loop
		
		int i = 0;
		int sum = 0;
		while (sum < 55)
		{
			i++;
			//System.out.println("I felt sad and ate "+ i +" donuts today");
			System.out.printf("I felt sad and ate $d donuts today.\n", i );
			sum += i;
		}
		//System.out.println("I felt happy and ate "+ sum +" donuts today :)");
		System.out.printf("I felt happy and ate $d donuts today :) \n", sum);
		
		// compare with for_loop
		int total = 0;
		for (int donuts = 0; total < 55 ; donuts++) 
		{
			System.out.println("I felt sad and ate "+ i +" donuts today");
			total += donuts;
		}
		System.out.println("I felt happy and ate "+ sum +" donuts today :)");
		
		// do while loop
		
		int j = 1;
		do 
		{
			int result = j * 2;
			System.out.println("product of " + j + " * 2 = " + result);
			j++;
		}
		while (j <= 12);
		//compare with do_whlie
		int k = 1;
		while (k <= 12)
		{
			int result_k = k *2;
			System.out.println("product of " + k + " * 2 = " + result_k);
			k++;
		}
		
		
		
	}

}
