package training.exampleclass;

public abstract class Vehicle { // 创建抽象类作为一个外部类
    protected String name;
    public Vehicle(String name){
        this.name = name;
    }
    public abstract void run(); // 创建抽象方法，用于在子类中重写

    public  void musicPlayer(){ // 创建一个正常方法，用于使用匿名内部类重写这个方法
        System.out.println( name + " is playing music.");
    }

    public class Car extends Vehicle { // 创建成员类作为一个内部类
        public Car(String name) {
            super(name);
        }
        @Override
        public void run() {
            System.out.println(name + " is running fast.");
        }

        public void airConditioner() {
            System.out.println(name + " is using air conditioner.");
        }
    }

    public class Bike extends Vehicle{ // 创建成员类作为一个内部类
        public Bike(String name){
            super(name);
        }
        @Override
        public void run(){
            System.out.println(name + " is running slow.");
        }

        public void bell(){
            System.out.println(name + " is ringing the bell.");
        }
    }

}
