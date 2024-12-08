package training.tutorial;

import training.tutorial.exampleclass.StudentsInfo;
import training.tutorial.exampleclass.PersonInfo;
import training.tutorial.exampleclass.CarInfo;

public class g_array2_objects {

	public static void main(String[] args) {
		// 可以使用Object Array保存不同的数据类型
		// 调用Students_info
		StudentsInfo Students[] = new StudentsInfo[3];
		Students[0] = new StudentsInfo(1,"KE",28);
		Students[1] = new StudentsInfo(2,"BO",29);
		Students[2] = new StudentsInfo(3,"BANGSHENG",29);
		for (int i = 0 ; i < Students.length; i++) {
			Students[i].print_info();
		}
		
		for (StudentsInfo Stu : Students) {
			Stu.print_info();
		}

		// 调用person_info
		PersonInfo xiaoxuanfeng[] = new PersonInfo[3];
		xiaoxuanfeng[0] = new PersonInfo("zhangke",28,'M');
		xiaoxuanfeng[1] = new PersonInfo("zhangbo",29,'M');
		xiaoxuanfeng[2] = new PersonInfo("xiaoma",29,'M');
		for (int i = 0 ; i < xiaoxuanfeng.length ; i++) {
			xiaoxuanfeng[i].print_info();
		}
		
		for (PersonInfo persons:xiaoxuanfeng) {
			persons.print_info();
		}
		
		// 调用之前创建的class-car_info
		CarInfo cars[] = new CarInfo[2];
		cars[0] = new CarInfo(2016,"Subaru");
		cars[1] = new CarInfo(2019,"Audi");
		for (int i = 0 ; i < cars.length ; i++) {
			cars[i].print_info();
		}
		
		for (CarInfo mycars : cars) {
			mycars.print_info();
		}
	}

}
