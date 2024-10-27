package training.tutorial;

import training.exampleclass.CarNumber;

public class i_Static_Variable_Method_Block {

	public static void main(String[] args) {
		// 在main方法第一步加载class的时候会马上执行static block
		// static variable 静态变量 在所有object中共享 直接通过class名访问
		CarNumber my_car1 = new CarNumber("audi");
		my_car1.brand_info();
		CarNumber my_car2 = new CarNumber("subaru");
		my_car2.brand_info();

		System.out.println(CarNumber.nums); // 直接通过class name : carnumbers来访问静态变量 nums

		// static method 静态方法 直接使用calss名称来访问 无需new bojects
		CarNumber.numbers_info();
	}

}
