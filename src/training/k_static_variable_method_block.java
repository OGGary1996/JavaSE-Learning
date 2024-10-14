package training;

import training.exampleclass.carnumbers;

public class k_static_variable_method_block {

	public static void main(String[] args) {
		// 在main方法第一步加载class的时候会马上执行static block
		// static variable 静态变量 在所有object中共享 直接通过class名访问
		carnumbers my_car1 = new carnumbers("audi");
		my_car1.brand_info();
		carnumbers my_car2 = new carnumbers("subaru");
		my_car2.brand_info();

		System.out.println(carnumbers.nums); // 直接通过class name : carnumbers来访问静态变量 nums

		// static method 静态方法 直接使用calss名称来访问 无需new bojects
		carnumbers.numbers_info();
	}

}
