package a_file;

// 本例子演示如何创建目录

import java.io.File;

public class a1_CreateDir {
    public static void main(String[] args) {
        // 创建File对象并指定目录的相对路径和名称
        File dir1 = new File("src/main/resources/file_examples");
            // 如果要指定绝对路径，可以使用如下方式
            // File dir1 = new File("C:/Users/username/Desktop/file_examples");（windows）
            // File dir1 = new File("/Users/username/Desktop/file_examples");（mac）
        // 创建目录
        if (dir1.mkdir()){
            System.out.println("Created directory successfully -> " + dir1.getAbsolutePath());
        }else{
            System.out.println("Failed to create directory, maybe it already exists -> " + dir1.getAbsolutePath());
        }

        // 创建多级目录
        File dir2 = new File("src/main/resources/file_examples/level1/level2");
        if (dir2.mkdirs()){
            System.out.println("Created directory successfully -> " + dir2.getAbsolutePath());
        }else{
            System.out.println("Failed to create directory, maybe it already exists -> " + dir2.getAbsolutePath());
        }
    }

}
