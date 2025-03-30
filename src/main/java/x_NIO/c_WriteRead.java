package x_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class c_WriteRead {
    public static void main(String[] args) {
        // 写入文件，如果文件不存则会自动创建
        Path filePath = Paths.get("src/main/resources/file_examples2/file2.txt");
        try{
            String data = "Hello World";
            Files.write(filePath,data.getBytes());
        }catch(IOException e){
            System.out.println("Something went wrong ->");
            e.printStackTrace();
        }

        // 读取文件
            // 1. 使用readAllBytes()方法读取文件,返回byte[]
        try{
            byte[] data = Files.readAllBytes(filePath);
            System.out.println(new String(data));
        }catch (IOException e) {
            System.out.println("Something went wrong ->");
            e.printStackTrace();
        }

            // 2. 使用readAllLines()方法读取文件,返回List<String>
        try{
            List<String> data = Files.readAllLines(filePath);
            System.out.println(data);
        }catch(IOException e){
            System.out.println("Something went wrong ->");
            e.printStackTrace();
        }
    }
}
