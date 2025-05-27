package a1_File;

// 本例子演示如何删除文件

import java.io.File;

public class b_Delete {
    public static void main(String[] args) {
        // 删除文件
        File file2 = new File("src/main/resources/file_examples/level1/level2/level3/file2.txt");
        if (file2.delete()){
            System.out.println("File deleted successfully from -> " + file2.getAbsolutePath());
        }else{
            System.out.println("Failed to delete a1_File, maybe it doesn't exist -> " + file2.getAbsolutePath());
        }

        // 删除目录
        File dir = new File("src/main/resources/file_examples/level1/level2/level3");
        if (dir.delete()){
            System.out.println("Directory deleted successfully from -> " + dir.getAbsolutePath());
        }else{
            System.out.println("Failed to delete directory, maybe it doesn't exist -> " + dir.getAbsolutePath());
        }
    }
}
