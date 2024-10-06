package training;

public class e_Loop {

	public static void main(String[] args) {

		// while loop 可以用于无限循环的loop
		int i = 1;
		while (i <= 5) 
		{
			System.out.println("hi~ " + i);
			i++; 
		}
		System.out.println("loop_end "+ i);
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
		
	}

}
