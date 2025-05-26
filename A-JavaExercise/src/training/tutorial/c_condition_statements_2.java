package training.tutorial;
// try-catch
// 在 Java 中，try-catch 语句用于异常处理，可以帮助程序在遇到错误（异常）时继续执行，而不是直接崩溃。
/// 异常是一种程序运行时的错误，比如除数为零、文件未找到等。
// 在 Java 中，异常被当作对象，try-catch 语句可以捕获这些异常并处理它们。
public class c_condition_statements_2 {

	public static void main(String[] args) {
		try{
			// 可能会产生异常的代码块
		} catch (Exception e) {
			// 处理异常的代码块
		}

		try{
			int[] numbers = {1,2,3,4};
			System.out.println(numbers[5]);// 没有index = 5 的元素
		} catch (Exception e){
			System.out.println("An error occurred");
		}

		try{
			int result = 10/0;
			System.out.println(result);
		} catch (ArithmeticException e){
			System.out.println("You can't divide by zero");
		}
		System.out.println("Process continues...");
	}

}
