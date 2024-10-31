package training.tutorial;
//Encapsulation 封装
// 通过设置private成员变量，这个变量在class外部无法访问 只能在class内部访问，实现数据保护
// 但是虽然private变量，但是仍然可以通过构造函数在new object时向这个变量传递参数，在之后就无法访问private变量了
import training.exampleclass.PersonalInfo;
import training.exampleclass.Classroom;

public class j_Encapsulation {
    public static void main(String[] args){
    // Example1
    PersonalInfo person1 = new PersonalInfo(null, 0);
    person1.setname("kezhang");
    person1.setage(28);
    System.out.println("Namme:"+person1.getname()+", age: "+ person1.getage());
    
    // Example2
    Classroom class1 = new Classroom();
    Classroom.Math math1 = class1.new Math();

    math1.setStudentCount();
    int result = math1.getStudentCount();
    System.out.println("The total number of students is: " + result);
    }
}
