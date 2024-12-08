package training.tutorial;
import training.tutorial.exampleclass.Animal;
import training.tutorial.exampleclass.Vehicle;
public class q_Innerclass1_Anonymous {
    public static void main(String[] args) {
// Anonymouse inner class 匿名内部类，位于一个方法内部，用于创建一个只需要使用一次的子类来重写父类或接口的方法，不需要单独创建一个子类从而简化代码和文件的管理
// 1. 匿名内部类没有类名，没有构造方法，没有静态成员，没有实现接口，没有继承类，只能使用一次
// 2. 匿名内部类不能是抽象的，因为它是匿名的，匿名内部类必须继承一个抽象类或实现一个接口
// 3. 匿名内部类不能定义任何静态成员、方法和类，通常只用于简化代码，不需要单独创建一个子类
// eg. 1 使用一个匿名类重写Animal类中的sleep()方法，输出“Animal is sleeping, please do not disturb.”
    Animal anonymous = new Animal("anonymous1"){ // 创建一个匿名类，因为是匿名类，所以不需要他的类名，直接在后面加上{}，并且在后面加上“;”
        @Override // 在这个匿名类中重写父类的sleep()方法
        public void sleep(){
            System.out.println("Animal is sleeping, please do not disturb.");
        }
    };
    anonymous.sleep(); // 用于一次性输出一个匿名类的方法

    // eg. 2 使用一个匿名类重写vehicle中的方法
    Vehicle anonymousVehicle = new Vehicle("anonymousVehicle1"){ // 创建一个匿名类，因为是匿名类，所以不需要他的类名，直接在后面加上{}，并且在后面加上“;”
        @Override // 在这个匿名类中重写父类的方法
        public void run(){
            System.out.println(name + " is running.");
        }
        public void musicPlayer(){
            System.out.println(name + " is playing music.");
        }
    };
    anonymousVehicle.run(); // 用于一次性输出一个匿名类的方法
    anonymousVehicle.musicPlayer(); // 用于一次性输出一个匿名类的方法
    }
}
