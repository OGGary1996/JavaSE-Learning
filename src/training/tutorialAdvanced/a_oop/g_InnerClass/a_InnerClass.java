package training.tutorialAdvanced.a_oop.g_InnerClass;

// 内部类是定义在另一个类中的类；分为成员内部类和静态内部类和局部内部类
// 为什么会出现内部类，为什么不直接使用两个类？
    // 1. 内部类不同于单独的两个类，使用单独的两个类通常是这两个类有继承关系，并且两个类都是独立且完整的个体。
    // 2. 内部类表示的通常是一个外部类的一个部分，一个组件；并非一个完整的个体。
    // 3. 并且通常内部类单独出现没有意义，所以我们将它定义在外部类中。

// 访问特点：
    // 1.内部类可以直接访问外部类的成员变量和方法，包括私有的成员变量和方法。（可以直接在内部类中定义方法来访问外部类的成员）
    // 2.外部类不能直接访问内部类的成员变量和方法，必须先创建内部类的对象。

//1. 成员内部类：
    // 1.定义在成员位置的类，属于外部类的一个成员。例如Car -> Engine
    // 2.作为成员，同样可以进行访问修饰符的修饰，private、protected、public、default
        // private：如果内部类是private，若想要创建这个内部类的对象，只能在外部类中定义一个方法来创建这个内部类。
        // private：如果内部类是private，获得到内部类的对象之后，我们也无法直接使用这个内部类中的方法，仍然需要在外部类中定义一个方法来调用内部类的成员。
        // 为了避免同时在创建内部类的对象，并且想要获取内部类成员的时候还需要再次创建内部类的对象，所以在外部类初始化的时候也直接创建内部类的对象。
    // 3.创建成员内部类有两种方式
        // 3.1 直接创建：Outer.Inner 对象名 = new Outer().new Inner(); 如果Inner是private，则会报错
        // 3.2 通过外部类提供的方法创建：Object 对象名 = Outer.方法名();此时外界不知道这个内部类的存在，所以类型应该写为Object


//2. 静态内部类
    // 1. 静态内部类也是成员内部类的一种
    // 2. 静态内部类只能访问外部类的静态成员变量和方法；如果想要访问外部类的非静态成员变量和方法，必须先创建外部类的对象。
    // 3. 创建静态内部类的对象并调用方法：
        // 3.1 直接创建：Outer.Inner 对象名 = new Outer.Inner(); 此时不需要创建外部类的对象
        // 3.2 调用方法：
            // 3.2.1 静态方法：Outer.inner.方法名(); 此时不需要创建外部类的对象与内部类的对象
            // 3.2.2 非静态方法：创建内部类的对象，然后通过对象来调用方法


//3. 局部内部类
    // 1. 局部内部类是定位在方法中的类，属于方法中的一个局部变量, 类似于public，protected,private不能用于修饰局部变量的，也不能修饰局部内部类
    // 2. 外界无法直接使用局部内部类，需要在方法内部创建对象来使用
    // 3. 局部内部类可以直接访问外部类的外部类的成员，也可以访问方法内部的局部变量


// 匿名内部类
    // 1. 匿名内部类是没有名字的内部类，所以不能通过名字引用，也没有构造器和静态方法，通常用于实现接口或者继承抽象类,
    //    对于接口实现，我们直接将接口的名字写在new的后面，此时new 并不是new一个接口的意思，而是new一个实现了这个接口的类。
    //    所以，匿名内部类实际上是 {方法重写} 这一部分。
    // 2. new 接口名/抽象类名(){方法重写}; 直接在new后面定义一个类的继承，或者接口的实现。
    //    这个表达式包含了3个含义，{方法重写} 是匿名内部类的实际类体，接口名/抽象类名是匿名内部类的父类或者接口，new 是创建匿名内部类的对象。


public class a_InnerClass {
    public static void main(String[] args) {
        // 1. 创建成员内部类的对象
            // 方法1，直接创建,如果此时内部类是private，则会报错
        //Car.Engine engine = new Car().new Engine();
            // 方法2，通过外部类提供的方法创建
        Object engine = new Car().createEngine();
            // 通过提供的方法访问内部类的成员变量和方法
        Car car = new Car("Audi","White", 2);
        car.carInfo();
        car.setEngineBrand("VW");
        car.setEnginePower(248);
        car.engineInfo();

        // 3. 创建局部内部类对应外部类的对象
        Outer outer = new Outer();
        outer.show();

        // 4. 创建匿名内部类的对象并且调用方法
        Swim swimmer = new Swim() {
            @Override
            public void swimming(){
                System.out.println("I can swim");
            }
        };
        swimmer.swimming();
            // 4.1 使用场景，假如有个test方法需要传入一个接口的对象，我们可以直接在调用test方法的时候传入一个匿名内部类的对象
        test(new Swim (){
            @Override
            public void swimming(){
                System.out.println("I can swim");
            }
        });
            // 通过Lambda表达式创建匿名内部类的对象并且调用方法
        test(() -> System.out.println("I can swim"));
    }

    public static void test(Swim swimmer){
        swimmer.swimming();
    };
}
