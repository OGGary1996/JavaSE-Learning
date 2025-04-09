package d_Apache_Commons_IO;
// FileUtils是Apache Commons IO中的一个类，提供了对文件和目录的操作方法。
// 它包含了文件的 读写、复制、删除、移动等常用操作。

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class a_FileUtils {
    public static void main(String[] args) {
        // 常用方法
        // 1. copyFile(File srcFile, File destFile) 复制文件
        File sourcesFile = new File("src/main/resources/file_examples/file8.bin");
        File targetFile = new File("src/main/resources/file_examples/file8_copy.bin");

        try {
            FileUtils.copyFile(sourcesFile, targetFile);
        } catch (IOException e) {
            System.out.println("复制文件失败");
            e.printStackTrace();
        }

        // 2. writeStringToFile(File file, String data) 将字符串写入文件
        File file = new File("src/main/resources/file_examples/file9.txt");
        try{
            FileUtils.writeStringToFile(file,"Hello, World!","UTF-8");
        }catch(IOException e){
            System.out.println("写入文件失败");
            e.printStackTrace();
        }

        // 3. readFileToString(File file) 读取文件内容
        try{
            FileUtils.readFileToString(file,"UTF-8");
        }catch(IOException e){
            System.out.println("读取文件失败");
            e.printStackTrace();
        }

        // 4. 删除文件或目录
            // 4.1 deleteDirectory(File directory) 删除目录
        File directory = new File("src/main/resources/file_examples_copy/level1");
        try {
            FileUtils.deleteDirectory(directory);
        }catch (IOException e){
            System.out.println("删除目录失败");
            e.printStackTrace();
        }
            // 4.2 cleanDirectory(File directory) 清空目录
        File directory1 = new File("src/main/resources/file_examples_copy/");
        try{
            FileUtils.cleanDirectory(directory1);
        }catch (IOException e){
            System.out.println("清空目录失败");
            e.printStackTrace();
        }

        // 5. sizeOfDirectory(File directory) 计算目录大小
        File directory2 = new File("src/main/resources/file_examples/");
        long size = FileUtils.sizeOfDirectory(directory2);
        System.out.println("目录大小为：" + size + "字节");

    }
}
