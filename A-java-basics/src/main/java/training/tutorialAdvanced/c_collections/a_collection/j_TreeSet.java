package training.tutorialAdvanced.c_collections.a_collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

// TreeSet内部使用TreeMap实现，而TreeMap底层是使用红黑树实现的，所以实现了自动排序
// ！！！ 需要注意的是，由于底层使用红黑树，并且红黑树可以提供排序的功能，但是在传递参数进入TreeSet的时候，必须同时指定排序的规则：
/*
1. TreeSet的底层源码：
    * 默认构造方法：如果 TreeSet 里存储的元素是 Integer、String 这些实现了 Comparable 接口的类型，它会使用传递参数类型的类中已经写好的compareTo方法进行排序。
    * 带 Comparator 的构造方法：TreeSet 允许传入一个 Comparator 的实现类，让用户自定义排序规则。
    * 换句话说，TreeSet 其实就是用 Comparator 来决定排序方式的。

2. 排序规则：
    * Integer 和 String 都是实现了 Comparable 接口的，默认提供了自然排序（升序）。
    * 如果 TreeSet 使用空参构造，没有提供 Comparator，它会调用 对应参数类型的类中的compareTo() 进行排序。
    * 如果你提供 Comparator，它会优先使用 Comparator，而不会用 compareTo()。

3. 使用自定义对象时：
    *必须提供一个比较规则，否则 TreeSet 无法确定元素的顺序，就会抛出异常。
    两种选择：
    1. 让自定义类实现 Comparable<T>，重写compareTo方法，实现排序规则。
    2. 在创建 TreeSet 时，传入 Comparator<T>（自定义排序）。
*/

class Demo1 {
    private String name;
    private int age;
    public Demo1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}


class Demo2 implements Comparable<Demo2>{
    private String name;
    private int age;
    public Demo2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public int compareTo(Demo2 o){
        return this.age - o.age; // 升序
    }
    @Override
    public String toString() {
        return "Demo2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

public class j_TreeSet {
    public static void main(String[] args) {
        // 创建Integer或者String对象的TreeSet，这个时候会使用这些类中已经实现的compareTo方法进行排序，也就是默认的自然排序
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Cherry");
        treeSet.add("Date");
        treeSet.add("Elderberry");
        treeSet.add("Fig");
        System.out.println("TreeSet: " + treeSet);

        // 1.使用自定义的参数类型并传递Comparator的实现类
            // 1.不在自定义参数类型中实现Comparable接口，而是在创建TreeSet的时候传入Comparator
        Set<Demo1> demo1Set = new TreeSet<>(Comparator.comparing(o -> o.getName()));
            // 等同于：
        Set<Demo1> demo1Set2 = new TreeSet<>((o1,o2) -> o1.getName().compareTo(o2.getName()));
            // 支持链式调用,先根据name排序，再根据age降序
        Set<Demo1> demoSet3 = new TreeSet<>(Comparator.comparing(Demo1::getName)
                                                    .thenComparing(Demo1::getAge)
                                                    .reversed());

        // 2.在自定义参数类型中实现Comparable接口
        Demo2 stu1 = new Demo2("John Smith", 18);
        Demo2 stu2 = new Demo2("Jane Doe", 20);
        Demo2 stu3 = new Demo2("Alice Johnson", 22);
        Demo2 stu4 = new Demo2("Bob Smith", 22); // 同样的年龄,此时不会添加成功
        Set<Demo2> demo2Set = new TreeSet<>();
        demo2Set.add(stu1);
        demo2Set.add(stu2);
        demo2Set.add(stu3);
        demo2Set.add(stu4); // 此时不会添加成功，因为在定义排序规则的时候只定义了年龄，如果年龄相同，则红黑树判定为相同的对象，则不会添加成功
        demo2Set.forEach(System.out::println);

    }
}
