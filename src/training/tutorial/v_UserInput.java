package training.tutorial;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class v_UserInput {
    public static void main(String[] args) throws IOException{
        // pintln() 是一个属于out对象的方法，该对象是java.io.PrintStream类的一个实例，而这个out对象是属于System类的一个静态成员
        // 所以我们通过使用System class的名称调用静态成员out，然后调用该对象的方法println()来输出字符串
        System.out.println("Hello World");

        // read()是一个属于in的方法，该对象是java.io.InputStream类的一个实例，而这个in对象也是属于System类的一个静态成员
        // 所以我们通过使用System class的名称调用静态成员in，然后调用该对象的方法read()来获取用户输入
        // 但是这个方法只能读取一个字节，所以我们需要将其转换为字符，然后再转换为整数，这个数字是ASCII码
        try{
            System.out.println("Please input a number: ");
            int num = System.in.read();
            System.out.println("The number you input is: " + num); // 输出结果是输入的字符的ASCII码
        }catch(IOException e){
            System.out.println(e);
        }

        // 为了解决上面的问题，我们可以使用BufferedReader类来读取用户输入
        // BufferedReader类是一个从字符输入流中读取文本的类，它继承自Reader类
        // InputStreamReader类是从字节流到字符流的桥接器，它读取字节，并使用指定的字符集将其解码为字符
        // System.in是一个标准的输入流，它是InputStream类的一个实例
        // BufferedReader类的readLine()方法用于读取一个文本行，但是它只能读取文本，所以我们需要将其转换为整数
        // Integer类的parseInt()方法用于将字符串转换为整数
        BufferedReader input2 = null;
        try{
            System.out.println("Please input a number: ");
            input2 = new BufferedReader(new InputStreamReader(System.in));
            // InputStreamReader input1 = new InputStreamReader(System.in);
            // input2 = new BufferedReader(input1);
            String strInput = input2.readLine();
            int num = Integer.parseInt(strInput);
            System.out.println("The number you input is: " + num);
        }catch(IOException e){
            System.out.println(e);
        }finally{
            input2.close();
        }

        // 为了解决上面的问题，我们可以使用Scanner类来读取用户输入
        // Scanner类是一个简单的文本扫描器，它可以使用正则表达式来解析基本类型和字符串
        // Scanner类的nextInt()方法用于读取一个整数
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a number: ");
        int num = input.nextInt();

    }
}
