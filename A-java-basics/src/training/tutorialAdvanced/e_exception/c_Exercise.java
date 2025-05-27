package training.tutorialAdvanced.e_exception;
import java.util.Scanner;

/*
* 需求：
*   1.键盘录入String姓名，int年龄
*   2.姓名长度在3-10，年龄范围18-40；超出这个范围是异常数据，需要重新录入，一直到正确为止。
* */

class People{
    private String name;
    private int age;
    public People(){}
    public People(String name, int age) {
        if(name.length() < 3 || name.length() > 10){
            throw new RuntimeException();
        }
        if (age < 18 || age > 40){
            throw new RuntimeException();
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

public class c_Exercise {
    public static void main(String[] args) {
        while(true){
            // 使用Scanner类获取键盘输入
            // try-with-resources语句，自动关闭资源
            try(Scanner sc = new Scanner(System.in)) {

            System.out.println("请输入姓名：");
            String name = sc.nextLine();
            System.out.println("请输入年龄：");
            int age = Integer.parseInt(sc.nextLine());//可能会有NumberFormatException异常
            // 创建一个People对象
            People p = new People(name,age);
            break; // 如果没有异常，创建完毕之后跳出循环。
            }catch(NumberFormatException e){
                e.printStackTrace();
                System.out.println("输入的年龄不是数字，请重新输入！");
                continue;
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println("输入的姓名长度或年龄范围不符合要求，请重新输入！");
                continue;
            }
        }
    }
}
