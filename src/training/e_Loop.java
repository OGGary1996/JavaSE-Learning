package training;

public class e_Loop {

	public static void main(String[] args) {

		// while loop 可以用于无限循环的loop
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

		// nested_while 
		int x = 1;
		while (x < 5) 
		{
			System.out.println("hello");
				int y = 1;
				while (y <= 3) 
				{
					System.out.println("你好");
					y++;
				}
				x++;
		}


		// do while 
		// while 会先检查条件是否满足，True再执行；do while 则会先执行一次之后再判断条件，如果False，那也会至少执行一次。
		int num1 = 6;
		do
		{
			System.out.println("hello");
			num1++;
		} 
		while (num1 <= 5); 
		
		
		// for loop 用于知道具体什么时候停止循环的时候
		// for 可以将计时器 条件 自增同时处理
		for(int num2 = 5 ; num2 >= 0 ; num2--)
		{
			System.out.println("helo "+ num2);
		}
		// ! for_loop会先执行num2 = 5，和判断num2>=0，的操作，再执行后面的代码块，最后再自增。
		
		//summarize: for_loop会适用于已知结束条件的情况，while_loop适用于不知道结束条件或者希望可以一直循环直到给出信号。

		//exercise1 
		int result = 0;
		for (int j = 1 ; j <= 10 ; j++) {
			sum = result + j;
		}
		System.out.println("sum = "+sum);
		
		
		// nested for loop
		for (int j = 1 ; j <= 10 ; j ++) {
			for (int k = 1 ; k <= 5 ; k++ ){
				System.out.println(k);
			}
			System.out.println("All ieration of j are done for "+i+" ieration of i");
		}
		
		// assignment 3
		//no.1 
		int sum_of_even = 0;
		for (int j = 1 ; j <= 100 ; j++) {
			if (j % 2 == 0) {
				sum_of_even += j;
			}
		}
		System.out.print("The sum of all even number is "+sum_of_even);
		System.out.println();
		
		//no.2
		int num_a = 0 , num_b = 1;
		System.out.print("The Fibonacci numbers are: "+num_a + " , " + num_b);
		for (int j = 1 ; j <= 18 ; j++ ) {
			int num_c = num_a + num_b;
			System.out.print(num_c+" , ");	
			num_a = num_b;
			num_b = num_c;
		}
		
		// no.3
		System.out.println();
		for (int j = 1 ; j <= 6; j++) {
			for (int k = 1 ; k <= (j+1) ; k++) {
				System.out.print("*");
			}
			System.out.println();
		}


		// break and continue
		// break 在循环语句中 break会立刻停止所有循环。
		// break在后面
		for (int j = 1 ; j <= 5 ; j++)
		{
			System.out.println("j = "+ j);
			if (j == 3)
			{
				break; // break之后的语句不会执行了，并且马上退出循环。
			}	
		}
		//break 在前面
		
		for (int j = 1 ; j <= 5 ; j++)
		{
			if (j == 3)
			{
				break; //break后面的print不会被执行。
			}	
			System.out.println("i = "+ i);

		}
		
		
		// continue 在循环语句中 continue会跳过本次循环 并且直接进行下一次循环
		// continue 在前
		for (int j = 1 ; j <= 10 ; j++)
		{
			System.out.println("j = " + j);
			if (j == 6)
			{
				continue;
			}
			System.out.println("A"); // continue 不会执行continue之后的printA语句，直接进入下一次循环。
		}
		
		// continue在后
		for (int j = 1 ; j <= 10 ; j++)
		{
			if (j == 6)
			{
				continue;  // continue 不会执行continue之后的print j和print A语句，直接进入下一次循环。
			}
			System.out.println("j = " + j);
			System.out.println("A"); 
		}
	}

}
