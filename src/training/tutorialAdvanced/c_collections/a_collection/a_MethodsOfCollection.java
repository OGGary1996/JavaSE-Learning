package training.tutorialAdvanced.c_collections.a_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Collection是所有集合的根接口，它是一个接口，所以不能直接实例化，需要调用对应的实现类
// 包含了一些共性的方法：
// add()、remove()、clear()、size()、isEmpty()、contains()等

class Student {
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
//    @Override
//    public boolean equals(Object o){
//        if (this == o) return true;
//        if (o == null || this.getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return this.name.equals(student.name) && this.age == student.age;
//    }
}


public class a_MethodsOfCollection {
    public static void main(String[] args) {
        // 使用ArrayList进行演示
        List<Integer> list1 = new ArrayList<>();
        // 添加元素
            // add()方法：向集合中添加元素
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
            // addAll()方法：向集合中添加多个元素
        List<Integer> subList = new ArrayList<>(Arrays.asList(6,7,8,9));
        list1.addAll(subList);
        System.out.println(list1);

        // 判断元素
            // contains()方法：判断集合中是否包含指定元素
        System.out.println("List1 contains 3?" + list1.contains(3));
            // containsAll()方法：判断集合中是否包含多个元素
        System.out.println("List1 contains subList?" + list1.containsAll(subList));

        // 删除元素
            // remove()方法：删除指定元素,可传递索引或元素
        list1.remove(Integer.valueOf(5));
        System.out.println(list1);
            // removeAll()方法：删除多个元素
        list1.removeAll(subList);
        System.out.println(list1);
            // clear()方法：清空集合
        list1.clear();
        System.out.println(list1);

        // !!! 在使用判断方法时，contains方法底层使用的是equals方法
            // 如果存入的是String，Integer etc.类型的对象，这个Class对equals方法进行过重写，并非比较的内存地址，则可以顺利进行判断是否存在。
            // 如果存入的是自定义的对象，equals方法没有重写，则是比较的内存地址，判断是否存在时会返回false
        Student stu1 = new Student("Bob", 18);
        Student stu2 = new Student("Tom", 20);
        Student stu3 = new Student("Gary", 28);
        List<Student> students = new ArrayList<>();
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        Student stu4 = new Student("Bob", 18);
        System.out.println("Students list contains Bob? " + students.contains(stu4)); // false


    }
}
