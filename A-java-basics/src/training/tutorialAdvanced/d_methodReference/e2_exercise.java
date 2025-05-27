package training.tutorialAdvanced.d_methodReference;

/*
* 需求：
*   1. 创建集合添加学生对象类型，属性字段有name和age
*   2. 只需要获取学生的name字段，并放在 数组 中
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class e2_exercise {
    public static void main(String[] args) {
        List<Person> demoList = new ArrayList<>();
        Collections.addAll(demoList,new Person("Ke",18),
                new Person("Tom",20),
                new Person("Jerry",22),
                new Person("Jenny",19));
        // 只需要获取学生的name字段，并放在 数组 中
        String[] names = demoList.stream().
                map(Person::getName).
                toArray(String[]::new);

    }
}
