package training.tutorial;
// Functional Interface 函数式接口
// 函数式接口是指只有一个抽象方法的接口，可以使用Lambda表达式来创建该接口的对象
// 如果要声明一个函数式接口，需要使用@FunctionalInterface注解
// 如果不使用Lambda表达式，可以使用匿名内部类来实现函数式接口，但是这样代码会显得冗余

import training.exampleinterface.Show;
import training.exampleinterface.ShowWIthParameter;
import training.exampleinterface.Add;

public class t_FunctionalInterface_LambdaExpression {
    public static void main(String[] args){
    // example1 使用匿名内部类实现普通interface 或者 Functional interface
        Show show = new Show(){
            @Override
            public void inShow(){
                System.out.println("Hello, this is Show interface");
            }
        };
        show.inShow();

    // example2 使用Lambda表达式来实现Functional interface
        Show show2 = () -> System.out.println("Hello, this is Show interface");
        // Lambda表达式省略掉了 new Show() 和 inShow() 方法的声明
        show2.inShow();
    // example3 使用Lambda表达式来实现需要参数传递的interface
        ShowWIthParameter showWithParameter = (str) -> System.out.println("Hello, this is ShowWIthParameter interface, and the parameter is: " + str);
        showWithParameter.inShowWithParameter("hello");
        // 此步骤省略了参数类型，因为Lambda表达式会自动推断参数类型
    
    // example4 使用Lambda表达式来实现有返回值的interface
        Add add1 = ( i, j) -> i + j; 
        System.out.println("The result of add1 is: " + add1.addition(1, 2));
        // 此步骤省略了参数类型和返回值关键字，因为Lambda表达式会自动推断参数类型和返回值
    }
}
