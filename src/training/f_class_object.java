package training;

public class f_class_object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 调用 car
		car my_car = new car(2016,"subaru");
		my_car.print_car_info();
		
		// 调用person
		person my_info = new person("ke",28);
		my_info.personal_info();
		
		// 调用calculator
		calculator test = new calculator();
		int result = test.add(6, 10);
		System.out.println(result);
		
	}

}
