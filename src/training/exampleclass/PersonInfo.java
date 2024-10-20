package training.exampleclass;

public class PersonInfo {
	String person_name;
	int person_age;
	char person_gender;
	public PersonInfo(String name , int age , char gender ){
		person_name = name;
		person_age = age;
		person_gender = gender;
	}
	public void print_info() {
		System.out.println("Name: "+person_name+", age: "+person_age+", gender: "+person_gender+".");
	}
}
