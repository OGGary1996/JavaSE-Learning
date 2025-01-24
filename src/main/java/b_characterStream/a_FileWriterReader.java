package b_characterStream;

// 本例子演示如何使用FileWriter和FileReader写入和读取文件

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class a_FileWriterReader {
    public static void main(String[] args) {
        // 使用FileWriter写入文件
            // 1. 创建需要被写入的文件对象
        File file2 = new File("src/main/resources/file_examples/file2.txt");
        File parentDir = file2.getParentFile(); // 获取父目录
        if (!parentDir.exists()){
            parentDir.mkdirs();
        }
        try{
            if (file2.createNewFile()){
                System.out.println("File created successfully -> " + file2.getAbsolutePath() + file2.getName());
            }else{
                System.out.println("Failed to create file, maybe it already exists ");
            }
        } catch (IOException e) {
           System.out.println("Something went wrong -> ");
              e.printStackTrace();
        }
            // 2. 创建FileWriter对象,创建这个对象必须使用try-catch块或者throws IOException
        try{
            FileWriter writer = new FileWriter("src/main/resources/file_examples/file2.txt");
            // 3. 使用write()方法写入文件
            writer.write("Hello, world!");
            // 4.关闭流
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }finally {
        }

        // 使用FileReader读取文件
        try{
            // 1.创建FileReader对象
            FileReader reader = new FileReader("src/main/resources/file_examples/file2.txt");
            // 2.读取文件 方法1，使用read()方法，返回读取字符的ASCII码
            int data ;
            while((data = reader.read()) != -1){
                System.out.print((char)data);
            }
            System.out.println();
            // 方法2 使用read(char[] cbuf)方法，返回读取的字符个数
//            char[] buf = new char[1024];
//            int length;
//            while((length = reader.read(buf)) != -1){
//                System.out.print(new String(buf, 0, length));
//            }
//            System.out.println();
            // 3.关闭流
            reader.close();
        }catch(IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }



    }
}
