package training;

	public class person{
		String name;
		int age;
		String gender;
		person(String name , int age , String gender){
			this.name = name;
			this.age = age;
			this.gender = gender;	
		}
		public void print_info(){
			System.out.println("The person's name: "+ name + ","+"age: " + age + "," + "gender: " + gender);
		}
	}