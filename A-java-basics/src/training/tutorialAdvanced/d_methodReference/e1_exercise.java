package training.tutorialAdvanced.d_methodReference;

/*
* 需求：
*   1.集合中储存一些字符串的数据，name+age
*   2.收集到Student类型的数组中
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    public Student(String str){
        String[] arr = str.split(",");
        this.name = arr[0];
        this.age = Integer.parseInt(arr[1]);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class e1_exercise {
    public static void main(String[] args) {
        List<String> demoList = new ArrayList();
        Collections.addAll(demoList,"Andy,18","Tom,20","Jerry,22","Jenny,19");
        List<Student> students = demoList.stream().
                map(Student::new).collect(Collectors.toList());
        // 验证结果
        students.forEach(System.out::println);
    }
}
