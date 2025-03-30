package a_file;

import java.io.File;

public class e2_RecursiveList {
    public static void recursiveDelete(File dir){
        File[] files = dir.listFiles();
        // 此时可以不写递归终止条件，因为在删除目录时，listFiles()方法会返回null，本身就是一种终止情况，则最后一层递归操作完成，终止递归。
        for (File file : files){
            if (file.isFile()){
                file.delete();
            }else if (file.isDirectory()){
                recursiveDelete(file);
            }
        }
        dir.delete(); // 后序遍历删除目录
    }

    public static void main(String[] args) {

    }
}
