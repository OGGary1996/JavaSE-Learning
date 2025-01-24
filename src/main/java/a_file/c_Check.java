package a_file;

// 本例子演示如何检查文件或目录是否存在,以及如何获取文件或目录的属性

import java.io.File;

public class c_Check {
    public static void main(String[] args) {
        // 检查文件是否存在
        File file1 = new File("src/main/resources/file_examples/file1.txt");
        if (file1.exists()){
            System.out.println("File exists -> " + file1.getAbsolutePath());
        }else{
            System.out.println("File doesn't exist -> " + file1.getAbsolutePath());
        }
        // 检查路径同理

        // 获取文件属性
            // 以下是一些常用的文件属性
        System.out.println("File name -> " + file1.getName());
        System.out.println("File path -> " + file1.getPath());
        System.out.println("File absolute path -> " + file1.getAbsolutePath());
        System.out.println("File parent -> " + file1.getParent());
        System.out.println("File last modified -> " + file1.lastModified());
        System.out.println("File size -> " + file1.length());
        System.out.println("File can read -> " + file1.canRead());
        System.out.println("File can write -> " + file1.canWrite());
            // 检查是否为文件或者目录
        if(file1.isFile()){
            System.out.println("File is a a_file");
        }else if (file1.isDirectory()){
            System.out.println("File is a directory");
        }else{
            System.out.println("File is not a a_file or directory");
        }
    }
}
