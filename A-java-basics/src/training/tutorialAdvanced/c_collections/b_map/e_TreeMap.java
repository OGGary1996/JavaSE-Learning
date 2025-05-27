package training.tutorialAdvanced.c_collections.b_map;

import java.util.*;

class Student implements Comparable<Student>{
    private String name;
    private int age;
    public Student(String name, int age) {
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o){
        return this.age - o.age; // 升序
    }
}

public class e_TreeMap {
    public static void main(String[] args) {
        // Map的排序规则只针对key进行排序，value的排序规则是没有的
        // 所以在使用Comparator或者实现Comparable接口时，排序的参数默认是key

        //1. 默认按照key的升序排列
        Map<Integer,String> demoMap = new TreeMap<>();
        demoMap.put(6,"F");
        demoMap.put(1,"A");
        demoMap.put(3,"C");
        demoMap.put(2,"B");
        demoMap.put(5,"E");
        demoMap.put(4,"D");
        demoMap.forEach((k,v) -> System.out.println(k + " -> " + v));
        // 2. 自定义排序
            // 2.1 以上的例子使用降序排序
        Map<Integer,String> demoMap2 = new TreeMap<>(Comparator.reverseOrder());
            // 等同于：
        //Map<Integer,String> demoMap2 = new TreeMap<>((o1,o2) -> o2-o1);
        demoMap2.put(6,"F");
        demoMap2.put(1,"A");
        demoMap2.put(3,"C");
        demoMap2.put(2,"B");
        demoMap2.put(5,"E");
        demoMap2.put(4,"D");
        demoMap2.forEach((k,v) -> System.out.println(k + " -> " + v));
            // 2.2 对象处理
        Map<Student,String> stuAddressMap = new TreeMap<>();
        Student s4 = new Student("Jerry", 31);
        Student s1 = new Student("Ke", 28);
        Student s3 = new Student("Tom", 30);
        Student s2 = new Student("Gary", 29);
        stuAddressMap.put(s4,"Beijing");
        stuAddressMap.put(s1,"Shanghai");
        stuAddressMap.put(s3,"Guangzhou");
        stuAddressMap.put(s2,"Shenzhen");
        stuAddressMap.forEach((k,v) -> System.out.println(k + " -> " + v));
            // 2.3 传递Comparator实现类，优先级别高于Comparable接口
        Map<Student,String> studentAddressMap2 = new TreeMap<>((o1,o2) -> {
            int i;
            i = (o2.getAge() - o1.getAge()) == 0 ? // 如果年龄相同的情况：
                    o1.getName().compareTo(o2.getName()) : // 按照名字升序排列
                    o2.getAge() - o1.getAge(); // 按照年龄降序排列
            return i;
        });
        studentAddressMap2.put(s4,"Beijing");
        studentAddressMap2.put(s1,"Shanghai");
        studentAddressMap2.put(s3,"Guangzhou");
        studentAddressMap2.put(s2,"Shenzhen");
        Set<Map.Entry<Student,String>> entrySet = studentAddressMap2.entrySet();
        entrySet.forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }
}
