package b_byteStream.a_fileIOStream;

// 需求：拷贝文件夹中的所有内容，包括子文件夹和文件

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class c_exercise_copyDirs {
    // 主方法，负责遍历的逻辑
    public static void copyDirectory(File dir,File targetDir) throws IOException {
        // 1. 判断目标文件夹是否存在，如果不存在则创建
        if (!targetDir.exists()){
            targetDir.mkdirs();
        }
        // 2. 遍历文件夹中的所有文件和子文件夹
        File[] files = dir.listFiles();
        for(File file : files){
            if (file.isFile()){ // 如果是文件，使用拷贝文件的方法
                copyFile(file,new File(targetDir, file.getName()));
            }else if (file.isDirectory()){ // 如果是文件夹，进入递归调用
                copyDirectory(file,new File(targetDir,file.getName()));
            }
        }
        // 注意：此时不需要单独拷贝文件夹本身，因为在递归调用中已经创建了目标文件夹
    }

    // 拷贝文件的方法
    public static void copyFile (File file,File targetFile) throws IOException {
        // 创建目标文件，但是必须保证父级目录存在，但是在主方法中第一步已经创建了targetFile父级目录，所以此处不需要这个步骤
        // 使用FileInputStream和FileOutputStream进行文件拷贝
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(targetFile);
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        // 关闭流
        fos.close();
        fis.close();
    }

    public static void main(String[] args) {
        File dir = new File("src/main/resources/file_examples");
        File targetDir = new File("src/main/resources/file_examples_copy");
        try {
            copyDirectory(dir,targetDir);
        }catch (IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }
    }
}
