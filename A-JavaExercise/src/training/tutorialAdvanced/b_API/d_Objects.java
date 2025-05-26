package training.tutorialAdvanced.b_API;

import java.util.Arrays;
import java.util.Objects;

// Objects提供了更安全的toString(),equals(),hashCode()方法
class Student{
    String name;
    int age;
    public Student() {
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.name).append(", Age: ").append(this.age);
        return sb.toString();
    }
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Student s = (Student) o;
        return this.name.equals(s.name) && this.age == s.age;
    }
}

public class d_Objects {
    public static void main(String[] args) {
        // toString()
        Student student = null;
            // 会先进行非空的判断，如果this Object为null，则返回“Unknown Student”，如果不是null，则返回该对象的toString()方法
        System.out.println(Objects.toString(student,"Unknown Student"));
        // equals()
            // 先进行非空的判断，如果this Object为null，则返回false，如果不是null，则返回该对象的equals()方法
        Student student1 = new Student("Tom", 20);
        System.out.println("Are equal? ->" + Objects.equals(student,student1)); // false,但是不会报错

        // deepEquals()
            // 用于比较复杂的数组或者集合，避免了Arrays.equals()方法只能比较地址的局限性
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Are equal? ->" + Arrays.equals(matrix1,matrix2));// false,因为地址是不一样的。
        System.out.println("Are deep equal? ->" + Arrays.deepEquals(matrix1,matrix2));// true,因为内容是一样的。
    }
}
