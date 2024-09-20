package training;

public class person {
	String name;
	int age;
	
	person(String name , int age ) {
		this.name = name;
		this.age = age;
	}
	public void personal_info() {
		System.out.println("name is " + this.name + ", age is " + this.age + " .");
	}

}
