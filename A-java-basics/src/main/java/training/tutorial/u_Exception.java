package training.tutorial;
// 在 Java 中，异常（Exception） 是指在程序执行过程中发生的错误或意外事件，导致程序的正常执行流程被中断。
// Java 中的异常是一种对象，表示程序中的错误状态。通过处理异常，程序可以在遇到问题时进行响应，而不是直接崩溃。

// Java 的异常类层次结构中最顶层是 Throwable，它有两个子类：
// 1. Error：表示严重的错误，通常无法恢复，如内存不足 (OutOfMemoryError)，Compile-time，Run-time，logical。
// 2. Exception：表示程序可以处理的异常，大部分异常都是 Exception 的子类，Run-time
class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}

// Exception 又分为两种：
public class u_Exception {
    public static void main(String[] args){
    // 异常处理的方式有两种：try-catch 和 throws
    // 1.1 try-catch：用于捕获异常，处理异常，使程序继续执行
        int i = 0;
        int j = 10;
        try{
            j = j / i;
        } // 整个代码块表示可能会出现问题的代码
        catch(Exception e){ // 表示接收异常Exception class的一个对象e
            System.out.println("Error: " + e); // 表示这个异常的信息
            j = j / 1; // 异常发生时的处理方法
        }
        System.out.println("The result of j is: " + j);
        System.out.println("The program is still running after the exception");
        // 这两行代码会继续执行，因为异常被捕获并处理了，程序不会崩溃
        // 但是，如果没有try-catch，程序会在异常出现时直接崩溃，不会运行后面的两行代码
        // 如果没有异常，程序会正常运行，不会执行catch块中的代码

        // 使用多个catch块来处理不同类型的异常
        // 如果try中可能出现多种错误，那么后续的catch必须包含所有可能的错误类型，否则会报错
        // 如果有错误类型没有在catch中声明，那么相当于没有处理这个错误，程序会直接崩溃，不会继续执行
        // 也可以在！！最后！！一个catch块中使用Exception类来捕获所有类型的异常，因为这个类是所有异常类的父类
        int[] arr = new int[5];
        int k = 0;
        int l = 5;
        try{
            System.out.println(arr[5]);
            System.out.println(l / k);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("something went wrong: " + e);
            System.out.println(arr[4]); // 处理方案
        }
        catch(ArithmeticException e){
            System.out.println("something went wrong: " + e);
            System.out.println(l / 1); // 处理方案
        }
        // 当try中第一个错误出现时，程序会直接跳到对应的catch块，后续的错误不会再执行。
        // 同样的，当try中没有异常，程序会直接跳过catch块，继续执行后续代码

        // 也可以使用finally块来执行无论是否出现异常都需要执行的代码
        // finally块中的代码无论是否出现异常都会执行，通常用于释放资源,在其中使用.close()方法
        int x = 0;
        int y = 10;
        try{
            y = y / x;
        }catch(Exception e){
            System.out.println("Error: " + e);
            y = 1;
            System.out.println("The result of y is: " + y);
        }finally{
            System.out.println("The program is still running after the exception");
        }

        int m = 2;
        int n = 10;
        try{
            n = n / m;
        }catch(Exception e){
            System.out.println("Error:" + e);
        }finally{
            System.out.println("The program is still running after the exception");
        }


    // 1.2. throw 用于在特定条件下 手动抛出异常
        int a = 10;
        int b = 9;
        try{
            b = b / a;
            if(b == 0){
                throw new ArithmeticException("b is 0, see default value");
            }
        }catch (ArithmeticException e) {
            b = 1;
            System.out.println("That is the default value: " + e);
        }
        System.out.println("The result of b is: " + b);
        System.out.println("The program is still running after the exception");

        int c = 10;
        int d = 9;
        try{
            d = d / c;
            if (d == 0){
                throw new MyException("see the default value");
            }
        }catch (MyException e){
            d = 1;
            System.out.println("That is the default value: " + e);
        }
        System.out.println("The result of d is: " + d);
        System.out.println("The program is still running after the exception");


        // 2. throws 用于声明一个方法可能抛出的异常
        // 如果一个方法可能抛出异常，但是不想在方法内部处理异常，可以在方法声明中使用throws关键字声明异常
        // 在调用这个方法时，调用者必须处理这个异常，catch，否则会报错

    }
}
