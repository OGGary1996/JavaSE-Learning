package training.tutorial.exampleClass;

public class StudentsInfo {
	int Student_id;
	String Student_name;
	int Student_age;
	public StudentsInfo(int id, String name,int age){
		Student_id = id;
		Student_name = name;
		Student_age = age;
	}
	public void print_info(){
		System.out.println("Student_id: "+Student_id+", Student_name: "+Student_name+", Student_age: "+Student_age+".");
	}
}
