package training;

import training.exampleclass.*; // *意思是文件夹下所有的文件，但不包含文件夹内的文件夹，所以如果有多级文件结构，必须指向需要调用的那个文件夹

public class f_class_object {

	public static void main(String[] args) {

		// 调用calculator
		calculators addnums = new calculators();
		System.out.println(addnums.add(3,5));
		//调用car_info
		car_info ZK = new car_info (2016,"Subaru");
		ZK.print_info();
		
		// 调用employees
	    Employees emp1 = new Employees("ke",1,8356.7);
    	emp1.print_bonus();

	}

}
