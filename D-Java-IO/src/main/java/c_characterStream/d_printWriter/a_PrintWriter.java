package c_characterStream.d_printWriter;

// PrintWriter类属于字符流的一部分，但是没有对应的输入流，只有输出流

import java.io.*;

public class a_PrintWriter {
    public static void main(String[] args) throws IOException {
        // 使用PrintWriter类用于写出到文件中，采用PrintWriter封装OutputStreamWriter + OutputStream
        // PrintWriter类在创建时默认不会自动flush，所以需要手动添加
        File file = new File("src/main/resources/file_examples/printWriter.bin");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        PrintWriter pw = new PrintWriter(osw,true);
        pw.println("Hello from System.out!");
        pw.print("This is a test.");
        pw.println();
        pw.printf("Name: %s, Age: %d","Ke",28);
        pw.close();
    }
}
