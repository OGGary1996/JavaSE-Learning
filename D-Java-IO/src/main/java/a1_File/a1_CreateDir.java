package a1_File;

// 本例子演示如何创建目录

import java.io.File;

public class a1_CreateDir {
    public static void main(String[] args) {
        // 创建File对象并指定目录的相对路径和名称
            // 如果要指定绝对路径，可以使用如下方式
            // File dir1 = new File("C:\\Users\\username\\Desktop\\file_examples");（windows）
            // File dir1 = new File("/Users/username/Desktop/file_examples");（mac）

        // 创建单层目录
        File exampleDir = new File("src/main/resources/file_examples");
        if(exampleDir.mkdir()){
            System.out.println("Directory created successfully -> " + exampleDir.getAbsolutePath());
        }else{
            System.out.println("Directory created failed, directory already exists -> " + exampleDir.getAbsolutePath());
        }

        // 创建多层目录
        File exampleDir2 = new File("src/main/resources/file_examples/level1/level2/level3");
        if (exampleDir2.mkdirs()){
            System.out.println("Directory created successfully -> " + exampleDir2.getAbsolutePath());
        }else{
            System.out.println("Directory created failed, directory already exists -> " + exampleDir2.getAbsolutePath());
        }

    }
}
