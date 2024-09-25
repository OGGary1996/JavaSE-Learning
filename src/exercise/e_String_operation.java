package exercise;

public class e_String_operation {

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
		
		
		// .equals() 比较字符串 并返回 boolean
		String str6 = "The quick brown fox jumped over the lazy dog";
		String str7 = "   The quIck Brown fox JumpeD Over the Lazy Dog ";
		String originalstr7 = null;
		originalstr7 = str7;
		if (str6.equals(str7))
		{
			System.out.println("The first String is equal to the second String.");
		}
		else
		{
			System.out.println("The first String is not equal to the second String.");
			str7 = str7.trim();
			str7 = str7.substring(0,1).toUpperCase() + str7.substring(1).toLowerCase();
			if (str6.equals(str7))
			{
				System.out.println("The first String is equal to the second String.");
				System.out.println("The first String is: " + str6);
				System.out.println("The second String: " + originalstr7 + " is repair to " + str7);
			}
		}
		// 如果不比较大小写，只比较内容
		str6.equalsIgnoreCase(str7);


		// .compareto() 比较字符串的unicode， > 返回正，< 返回负，= 返回0 
		String str8 = "Hello";
		String Str9 = "hello";
		int result = str8.compareTo(Str9);
		System.out.println(result);
		// 不比较大小写
		int result2 = str8.compareToIgnoreCase(Str9);
		System.out.println(result2);
		
		
		// .contains() ,to check if the sub String is present in the main String , it returns boolean.
		String str10 = "HelloWorld";
		String str11 = "World";
		System.out.println(str10.contains(str11));
		
		
		// .startswith() and .endswith() 检查所选的String开始或者结束的一个字符或者一个字符串是否跟提供的一致，返回boolean。
		System.out.println(str6.startsWith("The"));
		System.out.println(str7.endsWith("Dog"));
		
		
		// .indexof() and .lastindexof() 查询字符串中某个字符或者字符串第一次出现的index或者最后一次出现的index，如果找不到，则返回-1.
		System.out.println(str6.indexOf("fox"));
		System.out.println(str6.lastIndexOf("fox"));
		
		
		// .charAt() 获取字符串中的指定index位置的字符。
		char char1 = str10.charAt(0);
		System.out.println(char1);
		
		
		// exercise 反转字符
		String str12 = "!!!hay gnirts ytpme ,tArahc dna pool a gnisu gnirts eht detanetacnoc desrever uoy snoitalutargnoc";
		//for 
		for (int n = str12.length() - 1 ; n >= 0 ; n-- )
		{
			char c = str12.charAt(n);
			System.out.print(c);
		}
		
		// while
		String reverse = null;
		int index = str12.length() - 1;
		while (index >= 0)
		{
			char c = str12.charAt(index);
			reverse += c;
			index--;
		}
		System.out.println(reverse);
	}

}
