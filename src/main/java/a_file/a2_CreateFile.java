package a_file;

// 本例子演示如何创建文件

import java.io.File;
import java.io.IOException;

public class a2_CreateFile {
    public static void main(String[] args) {
        // 如果文件目录存在的情况下
        File file1 = new File("src/main/resources/file_examples/file1.txt");
        try{
            if (file1.createNewFile()){
                System.out.println("File created successfully -> " + file1.getAbsolutePath() + file1.getName());
            }else{
                System.out.println("Failed to create a_file, maybe it already exists -> " + file1.getAbsolutePath() + file1.getName());
            }
        }catch (Exception e){
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

        // 如果文件目录不存在的情况下, 会抛出异常
        File file = new File("non_existed/a_file.txt");
        try{
            file.createNewFile();
        }catch(IOException e){
            System.out.println("Something went wrong -> Path not found");
            e.printStackTrace();
        }

            // 增加逻辑判断，如果文件目录不存在，先创建目录
        File file2 = new File("src/main/resources/file_examples/level1/level2/level3/file2.txt");
        File parent = file2.getParentFile(); // 获取父目录
        if (!parent.exists()){ // 如果父目录不存在
            parent.mkdirs(); // 创建父目录
        }
        try{
            if(file2.createNewFile()){
                System.out.println("File created successfully -> " + file2.getAbsolutePath() + file2.getName());
            }else{
                System.out.println("Failed to create a_file, maybe it already exists -> " + file2.getAbsolutePath() + file2.getName());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }
    }
}
