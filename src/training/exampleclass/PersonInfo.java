package training.exampleclass;

public class PersonInfo implements Comparable<PersonInfo> {
	String name;
	int age;
	char gender;

	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
 
	// getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void print_info() {
		System.out.println("Name: "+name+", age: "+age+", gender: "+gender+".");
	}

	@Override
	public int compareTo(PersonInfo people){
		if (this.name.charAt(0) > people.name.charAt(0)){ 
			return 1; // 如果this.name的首字母大于people.name的首字母，返回1，this代表当前这个object，而参数表示要进行对比的另外的object
		} else {
			return -1;
		}
	}
}
