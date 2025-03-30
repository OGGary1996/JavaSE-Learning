package a_file;

// 本例子演示如何创建文件

import java.io.File;
import java.io.IOException;

public class a2_CreateFile {
    public static void main(String[] args) {
        // 如果文件目录存在的情况下
        File file1 = new File("src/main/resources/file_examples/file1.txt");
        try{
            file1.createNewFile();
            System.out.println("File created successfully -> " + file1.getAbsolutePath());
        }catch (IOException e){
            System.out.println("Something went wrong ->");
            e.printStackTrace();
        }
        // 如果文件目录不存在的情况下, 会抛出异常
//        File file2 = new File("non_existed/a_file.txt");
//        try{
//            file2.createNewFile();
//        }catch(IOException e){
//            System.out.println("Something went wrong -> Path not found");
//            e.printStackTrace();
//        }

        // 增加逻辑判断，如果文件目录不存在，先创建目录
        File multiLayerFile = new File("src/main/resources/file_examples/level1/level2/level3/multi-layer-file.txt");
        File parentDir = multiLayerFile.getParentFile();
        if (!parentDir.exists()){
            if (parentDir.mkdirs()){
                System.out.println("Directory created successfully -> " + parentDir.getAbsolutePath());
            }else{
                System.out.println("Directory created failed!");
            }
        }
        try{
            multiLayerFile.createNewFile();
            System.out.println("File created successfully -> " + multiLayerFile.getAbsolutePath());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
