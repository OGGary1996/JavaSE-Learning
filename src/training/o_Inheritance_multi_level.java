package training;
// 为了保留原始的parent class，并且创建child class时不用重写代码，所以我们使用inheritance
// multi-level inheritance 多重的继承

import training.exampleclass.AdvancedCalcu;
import training.exampleclass.VeryAdvancedCalcu;


public class o_Inheritance_multi_level {
    public static void main(String[] args){
        AdvancedCalcu num1 = new AdvancedCalcu(); // 创建child class 的 object
        System.out.println(num1.multi(5,3)); // 调用parent class中的方法。
        System.out.println(num1.mod(5,3));  // 调用 扩写的方法
        System.out.println(num1.div(2,0)); // 调用重写的方法

        VeryAdvancedCalcu num2 = new VeryAdvancedCalcu();
        System.out.println(num2.add(2,3)); // 调用更上一层的parent class的方法
        System.out.println(num2.multi(2,5)); // 调用parent class的方法
        System.out.println(num2.power(5,3)); // 调用扩写的方法


    }
}
