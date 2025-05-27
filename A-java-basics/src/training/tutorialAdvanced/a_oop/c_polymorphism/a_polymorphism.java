package training.tutorialAdvanced.a_oop.c_polymorphism;

// 多态的作用：
    // 1.多态可以提高代码的复用性，比如说在注册系统中，使用多态使得注册方法仅需接受一个共同的父类即可。
    // 2.多态可以根据不同的对象来调用不同的重写方法，从而实现不同的功能

// 多态调用成员的特点：
    // 1.变量调用：编译看左边，运行也看左边；指的是，如果通过多态方式创建对象之后，调用变量时，调用的是左边父类的变量；
    // 2.方法调用：编译看左边，运行看右边；指的是，如果通过多态方式创建对象之后，调用方法时，调用的是右边子类的重写方法；
        // 2.1 比如在子类中使用父类的set方法来对子类的变量进行赋值，虽然使用的是父类的方法，但是这个方法实际上是操作的this关键字指向的子类对象，所以实际上是操作的子类对象中的变量；

// 多态的优势：
    // 1.多态的形式，使得右边的多想可以实现解耦合，便于扩展维护
    // 2.定义方法时，使用父类作为参数，可与接受所有子类的对象
// 多态的缺点：
    // 1.由于方法调用时，编译会看左边，运行时会看右边，如果子类中有扩写的方法，则编译器无法知道这个方法的具体实现。
    // 2.多态的形式会导致代码的可读性降低，因为在调用方法时，编译器无法知道这个方法的具体实现，所以在阅读代码时，需要查看子类的实现才能知道这个方法的具体实现。
// 解决方案：使用类型转换来解决这个问题；比如，要想调用子类中特有的方法，我们将父类的引用重新转换为子类的引用；

public class a_polymorphism {
    public static void register(Person person){
        person.printInfo();
    }

    public static void main(String[] args) {
        Person s1 = new Student();
        s1.setName("John");
        s1.setAge(20);
        s1.setGender('M');
        Person t1 = new Teacher();
        t1.setName("Jane");
        t1.setAge(30);
        t1.setGender('F');
        // 通过父类引用调用子类对象的方法
        register(s1);
        register(t1);
        // 这整个过程中，我们始终在操作子类对象中的变量，只是通过从父类继承来的方法进行操作；因为方法是动态绑定。

        // 无法使用父类的引用调用子类特有的方法
        // 使用类型转换
//        Student new_s1 = (Student) s1;
//        new_s1.compliant();
        // 使用instanceof + 逻辑判断
        if (s1 instanceof Student) {
            Student new_s1 = (Student) s1;
            new_s1.compliant();
        } else if (s1 instanceof Teacher) {
            Teacher new_t1 = (Teacher) s1;
            new_t1.compliant();
        } else {
            System.out.println("Unknown type");
        }

    }
}
