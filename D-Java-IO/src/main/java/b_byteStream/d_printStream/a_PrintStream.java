package b_byteStream.d_printStream;

// PrintStream类属于字节流的一部分，但是没有对应的输入流，只有输出流

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class a_PrintStream {
    public static void main(String[] args) throws IOException {
        // 使用PrintStream类用于写出到控制文件中
        File file = new File("src/main/resources/file_examples/printStream.txt");
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        // PrintStream类在创建时默认会自动flush，所以不用手动添加
        ps.println("Hello from PrintStream!");
        ps.print("This is a test.");
        ps.println();
        ps.printf("Name: %s, Age: %d","Ke",28);
        ps.close();

        // 使用PrintStream类用于写出到控制台中
        // System.out: out是System中的一个静态成员，是一个PrintStream对象
        System.out.println("Hello from System.out!");
        // 在虚拟机启动之后，不能关闭System.out，否则无法进行输出到控制台。
    }
}
