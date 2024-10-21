package training.tutorial;

import training.exampleclass.*; // *意思是文件夹下所有的文件，但不包含文件夹内的文件夹，所以如果有多级文件结构，必须指向需要调用的那个文件夹

public class f_class_object {

	public static void main(String[] args) {

		// 调用calculator
		Calculators addnums = new Calculators();
		System.out.println(addnums.add(3,5));
		//调用car_info
		CarInfo ZK = new CarInfo (2016,"Subaru");
		ZK.print_info();

	}

}
