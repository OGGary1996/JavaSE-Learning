package exercise;

public class d_break_continue {

	public static void main(String[] args) {

		// break and continue
		// break 在循环语句中 break会立刻停止所有循环。
		// break在后面
		for (int i = 1 ; i <= 5 ; i++)
		{
			System.out.println("i = "+ i);
			if (i == 3)
			{
				break; // break之后的语句不会执行了，并且马上退出循环。
			}	
		}
		//break 在前面
		
		for (int i = 1 ; i <= 5 ; i++)
		{
			if (i == 3)
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
