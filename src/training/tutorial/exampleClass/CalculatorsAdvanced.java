package training.tutorial.exampleclass;

public class CalculatorsAdvanced extends Calculators { // 创建child class（同时为了保留原始的parent class，并且child class不用再次重写代码）
    public int mod(int num1, int num2){ // 扩展parent class 的方法
        return (num1 % num2);
    }

    @Override //重写parent class中的div()
    public final double div(double num1,double num2){
        if (num2 == 0){ // double type will not throw expections automatically when devided by 0.
            throw new ArithmeticException("Division by zero");
        }
        else{
            return num1 / num2;
        }
    }
}
