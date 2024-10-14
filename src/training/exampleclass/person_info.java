package training.exampleclass;

public class person_info {
	String person_name;
	int person_age;
	char person_gender;
	public person_info(String name , int age , char gender ){
		person_name = name;
		person_age = age;
		person_gender = gender;
	}
	public void print_info() {
		System.out.println("Name: "+person_name+", age: "+person_age+", gender: "+person_gender+".");
	}
}
