package a1_File;

// 本例子演示如何列出目录下的所有文件和目录

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d_List {
    public static void main(String[] args) {
        // 列出目录中的文件 名称
        File dir = new File("src/main/resources/file_examples");
        String[] children = dir.list();
        if (children != null){
            for (String child : children){
                System.out.println(child);
            }
        }else{
            System.out.println("Directory does not exist or is not a directory or is empty");
        }
        // 列出目录中的所有文件，并且是txt文件
        File dir2 = new File("src/main/resources/file_examples");
        String[] resultSet = dir2.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File obj = new File(dir,name);// 拼接为完整路径，表示其中的每个File对象
                if(obj.isFile() && name.endsWith(".txt")){
                    return true;
                }else{
                    return false;
                }
            }
        });
        if (resultSet == null){
            System.out.println("Directory does not exist or is not a directory or is empty");
        }else{
            for (String name : resultSet){
                System.out.println(name);
            }
        }


        // 列出目录中的文件!对象!
        File[] fileObjects = dir.listFiles();
        if (fileObjects != null) {
            for (File fileObject : fileObjects) {
                System.out.println(fileObject.getName());
            }
        }
        // 列出目录中的所有文件，并且是txt文件对象
            // 1.手动使用stream流式处理
        File[] resultFiles = dir2.listFiles();
        if (resultFiles !=null){
            List<File> fileList = new ArrayList<>(Arrays.asList(resultFiles));
            fileList.stream()
                    .filter(f -> f.isFile() && f.getName().endsWith(".txt"))
                    .forEach(System.out::println);
        }else{
            System.out.println("Directory does not exist or is not a directory or is empty");
        }

            // 2.使用FileFilter处理
        File[] resultFiles2 = dir2.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isFile() && file.getName().endsWith(".text")){
                    return true;
                }else{
                    return false;
                }
            }
        });
        if (resultFiles2 != null){
            for (File file : resultFiles2){
                System.out.println(file);
            }
        }
    }
}
