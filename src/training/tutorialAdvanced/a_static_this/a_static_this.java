package training.tutorialAdvanced.a_static_this;

// static 方法中不存在 this 关键字
    // this关键字是一个引用，指向当前对象的内存地址

// static 方法中不能访问非 static 成员变量和方法，
    // 因为 static方法汇总不包含this关键字，从而无法访问非 static 成员变量和方法

// 而非 static 方法中可以访问 static 成员变量和方法

// 内存加载：
    // 1.执行main方法，main方法被加载到stack memo
    // 2.JVM加载类到方法区，存储类的结构信息和方法
    // 3.将静态变量加载到heap memo中的静态区，优先于对象的加载，会先加载
    // 4.创建对象，加载到heap memo中的堆区

class Student {
    public static String teacher;
    private String name;
    private int age;
    public Student(){}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo(Student this){ // JVM会自动传入this，不需要显示传入
        System.out.println("Name: " + this.name + ", Age: " + this.age); // JVM会自动传入this，不需要显示传入
        showMSG(); //JVM此时会自动传入this，等于this.showMSG();表示this对应的对象在调用showMSG()方法
    }

    public void showMSG(){
        System.out.println("This MSG is for Testing");
    }

    public static void showTeacher() { // 此时不能在用this，因为static方法属于类本身，而不属于某个对象
        System.out.println("Teacher is: " + teacher);
        // System.out.println("Name: " + this.name + ", Age: " + this.age); // 不能访问非 static 成员变量和方法
    }
}

public class a_static_this {
    public static void main(String[] args) {
        Student.teacher = "Benz";
        Student s1 = new Student("Audi", 129);
    }
}
