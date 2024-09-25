package training;

public class f_class_object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 调用 car
		car my_car = new car(2016,"subaru");
		my_car.printinfo();
		
		// 调用person
		person my_info = new person("ke",28,"Male");
		my_info.print_info();
		
		// 调用calculator
		calculator add1 = new calculator();
		System.out.println(add1.add(3, 5));
	}

}
