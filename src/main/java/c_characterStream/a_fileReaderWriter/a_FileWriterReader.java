package c_characterStream.a_fileReaderWriter;

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
            file2.createNewFile();
            System.out.println("File created successfully -> " + file2.getAbsolutePath());
        } catch (IOException e) {
           System.out.println("Something went wrong -> ");
              e.printStackTrace();
        }
            // 2. 创建FileWriter对象,创建这个对象必须使用try-catch块或者throws IOException
        try (FileWriter fw = new FileWriter("src/main/resources/file_examples/file2.txt")){
            fw.write("Hello World!"); // 写入字符串
        }catch(IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }
            // 3. 使用FileReader读取文件
        try (FileReader fr = new FileReader("src/main/resources/file_examples/file2.txt")){
            char[] data = new char[1024];
            int len;
            while((len = fr.read(data)) != -1){
                System.out.println(new String(data,0,len));
            }
        }catch(IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }

    }
}
