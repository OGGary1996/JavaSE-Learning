package training.tutorial;
import training.tutorial.exampleclass.Vehicle;
public class q_Innerclass2_Menber {
// menber inner class 成员内部类：定义在类中的类，可以访问外部类的所有成员，包括私有成员，但是外部类不能访问内部类的成员，只能通过创建内部类的对象来访问
// 1. 成员内部类不能有静态成员，因为成员内部类是依赖于外部类的，只有在创建外部类的对象后才能创建内部类的对象
// 2. 外部类不能访问内部类的成员，只能通过创建内部类的对象来访问
// eg. 1 创建一个成员内部类，用于输出一个字符串
    public class innerClass {
        public void print(){
            System.out.println("This is a inner class.");
        }
    }
    public void createInnerClass(){
        innerClass inner = new innerClass(); // 可以直接在外部类中创建方法来创建一个内部类的对象
        inner.print();
    }

    public static void main(String[] args) {
    // 也可以在外部类mian静态方法中创建一个成员内部类的对象，但是static方法不能直接访问非静态成员（包括内部类），所以需要先创建一个外部类的对象
    q_Innerclass2_Menber outer = new q_Innerclass2_Menber();
    q_Innerclass2_Menber.innerClass inner = outer.new innerClass(); // 创建一个成员内部类的对象
    inner.print();
    // 或者在创建了外部类之后使用createInnerClass()方法来创建一个内部类的对象
    q_Innerclass2_Menber outer1 = new q_Innerclass2_Menber();
    outer1.createInnerClass();

    
    // eg. 2 调用Vehicle类中的成员内部类
    // 因为Vehicle是一个抽象类，所以不能直接创建Vehicle类的对象，只能通过创建Vehicle类的子类的对象来调用Vehicle类中的成员内部类
    // 通过创建一个匿名内部类来重写Vehicle类中的方法，同时创建了一个属于Vhicle类的的匿名子类，这个匿名子类可以用于创建成员内部类的对象
    Vehicle anonymousVehicle2 = new Vehicle("anonymousVehicle2") {
        @Override
        public void run() {
            System.out.println(name + " is ready to create a car or a bike.");
        }
    };

    // 创建Vehicle类的成员内部类的对象
    Vehicle.Car car1 = anonymousVehicle2.new Car("car1");
    car1.airConditioner();
    car1.run();
    car1.musicPlayer(); // 实现抽象类中的正常方法

    Vehicle.Bike bike1 = anonymousVehicle2.new Bike("bike1");
    bike1.bell();
    bike1.run();
    }
}