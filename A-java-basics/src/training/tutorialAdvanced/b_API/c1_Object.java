package training.tutorialAdvanced.b_API;

// Object class中的常用方法

import java.util.Objects;

class Person {
    String name;
    int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return "{Name : " + this.name + ", Age : " + this.age + ".}";
    }
    @Override
    public boolean equals(Object o){
        if (this == o ) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o; // 强制转换为Person类型
        return Objects.equals(this.name,person.name) && this.age == person.age;
    }
}


public class c1_Object {
    public static void main(String[] args) {
        // 1. toString()
        // 默认返回对象的类名 + 哈希码，与直接打印对象本身的结果是一致的，原因:
            // * System中的out是一个static变量，类型是PrintStream对象,
            // * 在PrintStream对象中，println方法中，如果传递的参数是一个对象，则会调用这个对象的的toString（）方法。
            // * 如果对象中没有对toString()方法进行重写，则会调用Object类中的toString()方法。
        // 一般按照需求 重写，比如希望看到对象内部的属性值：
        Person person = new Person("Tom", 18);
        System.out.println(person);

        // 2. equals()
        // 默认比较的是对象的内存地址，重写equals方法可以比较对象的属性值
            // * equals()方法的调用主要看调用者的类型
            // * 如果调用者的类型中没有重写这个方法，则调用Object类中的equals()方法
        Person person1 = new Person("Gary", 18);
        Person person2 = new Person("Gary", 18);
        System.out.println(person1.equals(person2)); // true

            // 2.1 example
        String str1 = "Hello!";
        StringBuilder sb = new StringBuilder("Hello!");
            // 使用str1的equals方法比较
            // false,因为String类中重写了equals方法，如果传递的参数不是String类型，则返回false
        System.out.println(str1.equals(sb)); // false
            // 使用sb的equals方法比较
            // false,因为StringBuilder类中没有重写equals方法，默认调用Object类中的equals方法
        System.out.println(sb.equals(str1)); // false
    }
}
