package training.tutorialAdvanced.c_collections.a_collection;

import java.util.ArrayList;

// 泛型通配符
class Ye{};
class Fu extends Ye{};
class Zi extends Fu{};


public class f3_GenericsWildcard {
    public static void method1(ArrayList<Ye> listYe){
        // ...
    }

    public static void method2(ArrayList<? extends Ye> list){
        // ? extends Ye表示list的元素类型是Ye的子类
    }

    public static void main(String[] args) {
        // 泛型不具备“继承”性值,不能将子类组成的集合传递进入父类组成的集合
        ArrayList<Ye> listYe = new ArrayList<>();
        ArrayList<Fu> listFu = new ArrayList<>();
        ArrayList<Zi> listZi = new ArrayList<>();
        method1(listYe);
        // method1(listFu); // 编译错误
        // method1(listZi); // 编译错误

        // 但是数据的“继承”性是存在的
        listYe.add(new Fu());
        listYe.add(new Zi());
        listFu.add(new Zi());

        // 如果想要方法传递时，限制传递的类型为Ye的子类，我们可以使用泛型通配符

    }
}
