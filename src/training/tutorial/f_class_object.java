package training.tutorial;

import training.tutorial.exampleclass.Calculators;
import training.tutorial.exampleclass.CarInfo;

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
