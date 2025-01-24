package d_NIO;

// 本例子采用NIO中的Files类中的静态方法来创建文件和目录

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class a1_CreatFileDirs {
    public static void main(String[] args) {
        // 创建文件
            // 使用Path, Paths类中的静态方法get()来创建Path对象
        Path dirPath = Paths.get("src/main/resources/file_examples2");
            // 创建目录,传递Path对象给Files.createDirectory()方法
        try{
            Files.createDirectory(dirPath);
            System.out.println("Directory created successfully");
        }catch(IOException e){
            System.out.println("Directory already exists");
            e.printStackTrace();
        }

            // 创建文件
        Path filePath = Paths.get("src/main/resources/file_examples2/file1.txt");
        try{
            Files.createFile(filePath);
            System.out.println("File created successfully");
        } catch (IOException e) {
            System.out.println("File already exists");
            e.printStackTrace();
        }
    }
}
