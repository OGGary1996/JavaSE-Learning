package exercise;

public class String_operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// + or .concat() 方法
		String str1 = "hello";
		String str2 = "world";
		System.out.println(str1+str2);
		System.out.println(str1.concat(str2));
		// concatenate integers and numbers 直接相加
		String str3 = "hello";
		String str4 = "world";
		int num1 = 100;
		System.out.println(str3+str4+num1);
		
		// .length() 方法
		String str5 = "today is sunny.";
		System.out.println("the length is "+str5.length());
		// .trim() 方法，去除string中的所有空格
		System.out.println(str5.trim());
		// .toUpperCase(),.toLowerCase() ,调整string中的大小写
		
		// .isEmpty() 方法, 判断string是否为空 返回值是True or False
		System.out.println(str5.isEmpty());		
		
	}

}
