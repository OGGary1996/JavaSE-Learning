package a_file;
// 使用递归的方式列出目录下的所有文件和目录
import java.io.File;

public class e1_RecursiveList {
    public static void recursiveList(File dir){
        File[] files = dir.listFiles();
        if (files == null){ // 递归终止条件
            System.out.println("Directory does not exist or is not a directory or is empty");
            return;
        }
        // 此时可以不用声明递归的终止条件，如果没有文件，files会是null，本身就是一种终止条件，递归操作最后一层执行完毕，开始返回
        for(File file : files){
            if (file.isDirectory()){
                recursiveList(file);
            }else{
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        File dir = new File("src/main/resources");
        recursiveList(dir);

    }
}
