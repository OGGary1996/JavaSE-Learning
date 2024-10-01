package training;

public class j_immutable_muitable_String {

	public static void main(String[] args) {
		// Immutable, String 不可变，对于String的修改实际上是创建了一个新的Object String
		
		// 通过直接赋值方式创建的String，会将String存储在 HEAP 中的 String pool 中；
		// 如果再次创建String，会先在pool中查找有没有存在的String，有则引用；无则在pool中直接新建object。
		String str1 = "HELLO";
		String str2 = "HELLO";
		System.out.println(str1 == str2); // True,内存地址一致。
		
		String str3 = "ZHANGKE";
		str3 = "Hello" + str3; // 此时创建了一个新的String，HelloZHANGKE ,str3内存指向会从ZHANGKE更改为HelloZHANGKE。
		
		
		// Mutable , 可以调用两种可修改string的class 
		// StringBuffer StringBuider
		StringBuffer strb = new StringBuffer("KE");
		System.out.println(strb);
		
		//常用method
		strb.append(" ZHANG");
		System.out.println(strb);
		
		strb.insert(0, "Hello ");
		System.out.println(strb);
		
		strb.delete(0, 6);
		System.out.println(strb);
		
		strb.reverse();
		System.out.println(strb);
	}

}
