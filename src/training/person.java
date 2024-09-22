package training;

public class person{
	String name;
	int age;
	char gender;
	
	person(String name, int age, char gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void print_info() {
		System.out.println("Name is: "+ this.name + " , age is : " + this.age +  " , gender is: " + gender);
	}
}