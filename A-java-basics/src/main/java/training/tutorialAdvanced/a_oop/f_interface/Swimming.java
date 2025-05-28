package training.tutorialAdvanced.a_oop.f_interface;

public interface Swimming extends Ability{ // 接口可以继承其他接口
    // 接口中的方法默认是public abstract的
    public abstract void swim();

    // 接口的常量作为成员变量，默认是public static final的
    public static final int MAX_SPEED = 100;

    // 接口中也可以定义方法体，作为默认的实现，使用default修饰
    // 接口中也可以定义静态方法，使用static修饰
    public static void swimFast() {
        System.out.println("No animal can swim faster than " + MAX_SPEED + "km/h");
    }
}
