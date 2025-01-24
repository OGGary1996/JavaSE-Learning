package a_file;

// 本例子演示如何列出目录下的所有文件和目录

import java.io.File;

public class d_List {
    public static void main(String[] args) {
        // 列出目录中的文件名称
        File dir = new File("src/main/resources/file_examples");
        String[] children = dir.list();
        if (children != null){
            for (String child : children){
                System.out.println(child);
            }
        }else{
            System.out.println("Directory does not exist or is not a directory");
        }

        // 列出目录中的文件!对象!
        File[] fileObjects = dir.listFiles();
        if (fileObjects != null) {
            for (File fileObject : fileObjects) {
                System.out.println(fileObject.getName());
            }
        }
    }
}
