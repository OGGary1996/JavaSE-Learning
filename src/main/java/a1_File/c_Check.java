package a1_File;

// 本例子演示如何检查文件或目录是否存在,以及如何获取文件或目录的属性

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class c_Check {
    public static void main(String[] args) {
        // 检查类
            // 检查文件是否存在，是否为文件或目录
        File file1 = new File("src/main/resources/file_examples/file1.txt");
        if (file1.exists()){
            System.out.println("File exists -> " + file1.getAbsolutePath());
        }else{
            System.out.println("File doesn't exist -> " + file1.getAbsolutePath());
        }
        if (file1.isFile()){
            System.out.println("File Object is a file");
        }else if (file1.isDirectory()){
            System.out.println("File Object is a directory");
        }else{
            System.out.println("File Object is neither a file nor a directory");
        }

        // 获取类
            // 以下是一些常用的文件属性
        System.out.println("Size of File(Bytes) -> " + file1.length());
        System.out.println("File' path -> " + file1.getPath()); // 创建File对象时指定的路径，可能是绝对路径，也可能是相对路径
        System.out.println("File's absolute path -> " + file1.getAbsolutePath()); // 绝对路径
        System.out.println("File's name -> " + file1.getName()); // 文件名 + 扩展名
        System.out.println("Last modified time -> " + file1.lastModified()/60000 + " minutes ago"); // 最后修改时间，单位为毫秒
            // 将Time转换为可读格式，YYYY-MM-DD HH:MM:SS
        System.out.println("Last modified time -> " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file1.lastModified())));
            // 获取父级目录或者父级File对象
        System.out.println("Parent directory -> " + file1.getParent());
        File parentOfFile1 = file1.getParentFile();
        System.out.println("Parent directory -> " + parentOfFile1.getName() + " (File Object)");
    }
}
