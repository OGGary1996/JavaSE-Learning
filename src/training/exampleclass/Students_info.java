package training.exampleclass;

public class Students_info {
	int Student_id;
	String Student_name;
	int Student_age;
	public Students_info(int id, String name,int age){
		Student_id = id;
		Student_name = name;
		Student_age = age;
	}
	public void print_info(){
		System.out.println("Student_id: "+Student_id+", Student_name: "+Student_name+", Student_age: "+Student_age+".");
	}
}
