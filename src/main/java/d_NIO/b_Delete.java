package d_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class b_Delete {
    public static void main(String[] args) {
        // 删除文件，如果不存在则抛出NoSuchFileException
        Path filePath = Paths.get("src/main/resources/file_examples2/level1/level2/file1.text");
        try{
            Files.delete(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 删除目录,如果
        Path dirPath = Paths.get("src/main/resources/file_examples2/level1/level2");
        try{
            Files.delete(dirPath);
        }catch(IOException e){
            System.out.println("Directory already exists");
            e.printStackTrace();
        }

        // 不确定文件是否存在
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
