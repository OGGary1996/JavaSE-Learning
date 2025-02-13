package Reflection.c_operations;

// 本例子通过反射创建对象

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Person {
    public String name;
    private int age;
    private Boolean isMarried;

    public Person(){
    }
    public Person(String name, int age, Boolean isMarried){
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
    }
        public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
        System.out.println("Set age to " + age);
    }
    public Boolean getMarried() {
        return isMarried;
    }
    public void setMarried(Boolean married) {
        isMarried = married;
        System.out.println("Set married to " + married);
    }

    @Override
    public String toString(){
        System.out.println("Name: " + name + ", Age: " + age + ", Married: " + isMarried);
        return null;
    }
}

public class a_creatNewObject {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 通过无参构造器创建对象
            // 1.获取Class对象和无参构造器
        Class<?> personClass = Person.class;
        Constructor<?> noArgsConstructors = personClass.getDeclaredConstructor();
            // 2.创建对象
        Object person1 = noArgsConstructors.newInstance();// 这里的Object是Object类的对象，不是Person类的对象，所以无法调用Person类的方法
        System.out.println(person1); // 输出：Reflection.c_operations.Person@1b6d3586

        // 通过有参构造器创建对象
            // 1.获取Class对象和有参构造器
        Constructor<?> argsConstructor = personClass.getDeclaredConstructor(String.class,int.class,Boolean.class);
            // 2.创建对象
        Object person2 = argsConstructor.newInstance("Ke",28,true);// 这里的Object是Object类的对象，不是Person类的对象，所以无法调用Person类的方法
    }
}
