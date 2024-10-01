package training;

class carnumbers{
	static int nums;
	String brand;
	carnumbers(String brand){
		this.brand = brand;
		nums++;  // 每次新增一个车辆之后nums会加1
	}
	public void brand_info(){
		System.out.println("brand: " + brand);
	}
	public static void numbers_info(){ // 创建静态方法
		System.out.println("numbers: " + nums);
	}

}

public class k_static_variable_method_block {

	public static void main(String[] args) {
		// static variable 静态变量 在所有object中共享 直接通过class名访问
		carnumbers my_car1 = new carnumbers("audi");
		carnumbers my_car2 = new carnumbers("subaru") ;
		
		System.out.println(carnumbers.nums); // 直接通过class name : carnumbers来访问静态变量 nums


		// static method 静态方法
		carnumbers.numbers_info();
	}

}
