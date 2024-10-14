package training;

import training.exampleclass.Students_info;
import training.exampleclass.person_info;
import training.exampleclass.car_info;

public class h_array_of_objects {

	public static void main(String[] args) {
		// 可以使用Object Array保存不同的数据类型
		// 调用Students_info
		Students_info Students[] = new Students_info[3];
		Students[0] = new Students_info(1,"KE",28);
		Students[1] = new Students_info(2,"BO",29);
		Students[2] = new Students_info(3,"BANGSHENG",29);
		for (int i = 0 ; i < Students.length; i++) {
			Students[i].print_info();
		}
		
		for (Students_info Stu : Students) {
			Stu.print_info();
		}

		// 调用person_info
		person_info xiaoxuanfeng[] = new person_info[3];
		xiaoxuanfeng[0] = new person_info("zhangke",28,'M');
		xiaoxuanfeng[1] = new person_info("zhangbo",29,'M');
		xiaoxuanfeng[2] = new person_info("xiaoma",29,'M');
		for (int i = 0 ; i < xiaoxuanfeng.length ; i++) {
			xiaoxuanfeng[i].print_info();
		}
		
		for (person_info persons:xiaoxuanfeng) {
			persons.print_info();
		}
		
		// 调用之前创建的class-car_info
		car_info cars[] = new car_info[2];
		cars[0] = new car_info(2016,"Subaru");
		cars[1] = new car_info(2019,"Audi");
		for (int i = 0 ; i < cars.length ; i++) {
			cars[i].print_info();
		}
		
		for (car_info mycars : cars) {
			mycars.print_info();
		}
	}

}
