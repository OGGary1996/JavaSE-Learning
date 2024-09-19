package training;

public class a_type_conversion_ann_casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 将小范围转为大范围
		byte b = 127;
		int a = 256;
		a = b;
		System.out.println("a = "+a);
		
		// 将大范围转为小范围，且大范围的值在小范围内
		byte c = 127;
		int d  = 12;
		c = (byte)d; //必须要添加（类型）
		System.out.println("c = "+c);
		// 将float转换为int
		float y = 5.6f;
		int x = (int)y;
		System.out.println("x = "+x);
		// float的精度会丢失
		
		//如果d的范围超过了byte允许的范围
		int e = 257;
		byte f = (byte)e;
		System.out.println("f = "+f);
		//int占位是32位，byte占位是8位，先进行模运算将257转换为二进制，由于byte只占位8，所以只能取257二进制转换后的后的后8位，
		//即0000 0001，结果为1.
		
		byte g = 10;
		byte h = 30;
		int result = g * h;
		System.out.println(result);
		
	}

}
