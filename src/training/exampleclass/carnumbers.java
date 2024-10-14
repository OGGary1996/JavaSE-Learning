package training.exampleclass;

public class carnumbers {
	public static int nums; // 声明静态变量
	public String brand;

	static { // static block 初始化static variables
		System.out.println("static block is excuted");
		nums = 0; // 初始化static variable nums
	}

	public carnumbers(String brand){
		this.brand = brand;
		nums++;  // 每次新增一个车辆之后 static variavle nums会加1
	}

	public void brand_info(){
		System.out.println("brand: " + brand);
	}
	public static void numbers_info(){ // 创建静态方法
		System.out.println("numbers: " + nums);
	}
}
