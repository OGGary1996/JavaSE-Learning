package training.tutorialAdvanced.a_oop.e_abstract;

// 注意事项：
    // 1. 抽象类不能被实例化，可以不用声明构造方法，但是也可以有构造方法，比如Person类不能被实例化
        // 1.1 因为子类可以使用父类的构造方法给子类的属性进行初始化，所以抽象类也可以有构造方法
    // 2. 抽象类可以包含抽象方法和非抽象方法，以及其他的属性；但是有抽象方法的类必须声明为抽象类，哪怕只有一个抽象方法
        // 2.1 抽象类中甚至可以没有抽象方法
    // 3. 抽象类的子类必须实现 所有 的抽象方法，除非子类也是抽象类。

// 意义：
    // 1. 强制子类必须实现父类的抽象方法，包括强制命名规则
    // 2. 抽象类可以包含一些公共的属性和方法，子类可以直接使用

public class a_abstract {
    public static void main(String[] args) {
        Person stu = new Student("Zhang", 20);
        Person tea = new Teacher("Li", 30);
        stu.work();
        tea.work();

    }
}
