package training;

public class f_class_object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 调用 car
		car my_car = new car(2016,"subaru");
		my_car.printinfo();
		
		// 调用person
		person my_info = new person("ke", 28 ,'M');
		my_info.print_info();
		
		// 调用calculator
		calculator text1 = new calculator();
		System.out.println(text1.add(3, 5));
		calculator text2 = new calculator();
		System.out.println(text2.time(3, 5));
	}

}
