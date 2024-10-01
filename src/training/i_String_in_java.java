package training;

public class i_String_in_java {

	public static void main(String[] args) {

		// String 本质上是java中的一个class 
		
		// create String
		String name = "HELLO";
		String name2 = new String("ZHANGKE");
		
		//method
			// 修改
		System.out.println(name.concat(" "+ name2));
		System.out.println(name + " " + name2);
		System.out.println(name.trim());
		System.out.println(name.toLowerCase());
		System.out.println(name.isEmpty());
			// 判断和比较
		System.out.println(name.equals(name2));
		System.out.println(name.equalsIgnoreCase(name2));
		System.out.println(name.compareTo(name2));
		System.out.println(name.compareToIgnoreCase(name2));
		System.out.println(name.contains(name2));
			// index
		System.out.println(name.length());
		System.out.println(name.charAt(2));
		System.out.println(name.indexOf('L'));
		System.out.println(name.lastIndexOf('L'));
		
	}

}
