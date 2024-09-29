package training;

class Students_info{
	int Student_id;
	String Student_name;
	int Student_age;
	Students_info(int id, String name,int age){
		Student_id = id;
		Student_name = name;
		Student_age = age;
	}
	public void print_info(){
		System.out.println("Student_id: "+Student_id+", Student_name: "+Student_name+", Student_age: "+Student_age+".");
	}
}

class person_info{
	String person_name;
	int person_age;
	char person_gender;
	person_info(String name , int age , char gender ){
		person_name = name;
		person_age = age;
		person_gender = gender;
	}
	public void print_info() {
		System.out.println("Name: "+person_name+", age: "+person_age+", gender: "+person_gender+".");
	}
}


public class h_array_of_objects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 可以使用Object Array保存不同的数据类型
		// 调用Students_info
		Students_info Students[] = new Students_info[3];
		Students[0] = new Students_info(1,"KE",28);
		Students[1] = new Students_info(2,"BO",29);
		Students[2] = new Students_info(3,"BANGSHENG",29);
		for (int i = 0 ; i < Students.length; i++) {
			Students[i].print_info();
		}
		// 调用person_info
		person_info xiaoxuanfeng[] = new person_info[3];
		xiaoxuanfeng[0] = new person_info("zhangke",28,'M');
		xiaoxuanfeng[1] = new person_info("zhangbo",29,'M');
		xiaoxuanfeng[2] = new person_info("xiaoma",29,'M');
		for (int i = 0 ; i < xiaoxuanfeng.length ; i++) {
			xiaoxuanfeng[i].print_info();
		}
		
		// 调用之前创建的class-car_info
		car_info cars[] = new car_info[2];
		cars[0] = new car_info(2016,"Subaru");
		cars[1] = new car_info(2019,"Audi");
		for (int i = 0 ; i < cars.length ; i++) {
			cars[i].print_info();
		}
	}

}
