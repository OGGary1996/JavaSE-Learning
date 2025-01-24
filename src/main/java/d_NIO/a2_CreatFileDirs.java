package d_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class a2_CreatFileDirs {
    public static void main(String[] args) {
        // 创建文件之前检测路径是否存在，不存在则创建路径
        Path filePath = Paths.get("src/main/resources/file_examples2/level1/level2/file1.text");
        try{
            if (!Files.exists(filePath.getParent())){
                Files.createDirectories(filePath.getParent());
            }
            Files.createFile(filePath);
            System.out.println("File created successfully -> " + filePath);
        }catch(IOException e){
            System.out.println("Files already exists");
            e.printStackTrace();
        }

    }
}
