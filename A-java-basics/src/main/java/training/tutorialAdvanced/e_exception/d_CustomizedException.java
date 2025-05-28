package training.tutorialAdvanced.e_exception;

import java.util.Scanner;

//定义一个继承自RuntimeException的自定义异常类
class NameLengthOutOfBoundsException extends RuntimeException {
    public NameLengthOutOfBoundsException() {
    }
    public NameLengthOutOfBoundsException(String message) {
        super(message);
    }
}

class AgeOutOfBoundsException extends RuntimeException {
    public AgeOutOfBoundsException() {
    }
    public AgeOutOfBoundsException(String message) {
        super(message);
    }
}

// 自定义异常类
class Person{
    private String name;
    private int age;
    public Person(){}
    public Person(String name, int age) {
        if(name.length() < 3 || name.length() > 10){
            throw new NameLengthOutOfBoundsException(name + "的长度不符合要求");
        }
        if (age < 18 || age > 40){
            throw new AgeOutOfBoundsException(age + "的范围不符合要求");
        }
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class d_CustomizedException {
    public static void main(String[] args) {
        while(true){
            try (Scanner sc = new Scanner(System.in)){
                System.out.println("请输入姓名：");
                String name = sc.nextLine();
                System.out.println("请输入年龄：");
                int age = Integer.parseInt(sc.nextLine()); // 可能会有NumberFormatException异常
                Person p = new Person(name, age);
            }catch(NameLengthOutOfBoundsException | AgeOutOfBoundsException e){
                e.printStackTrace();
            }catch(NumberFormatException e){
                e.printStackTrace();
                System.out.println("输入的年龄不是数字，请重新输入！");
            }
        }
    }
}
