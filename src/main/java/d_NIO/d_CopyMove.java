package d_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class d_CopyMove {
    public static void main(String[] args) {
        // 复制文件
        Path sourcesPath = Paths.get("src/main/resources/file_examples2/file2.txt");
        Path targetPath = Paths.get("src/main/resources/file_examples2/file2_copy.txt");
        try{
            Files.copy(sourcesPath,targetPath);
            System.out.println("File copied successfully -> " + targetPath);
        } catch (IOException e) {
            System.out.println("Something went wrong ->");
            e.printStackTrace();
        }

        // 移动文件,如果移动的目的地与原文件相同，可以重命名文件
            // 移动文件
        Path sourcesPath2 = Paths.get("src/main/resources/file_examples2/file2_copy.txt");
        Path targetPath2 = Paths.get("src/main/resources/file_examples2/level1/file2_copy.txt");
        try{
            Files.move(sourcesPath2,targetPath2);
            System.out.println("File moved successfully -> " + targetPath2);
        } catch (IOException e) {
            System.out.println("Something went wrong ->");
            e.printStackTrace();
        }

            // 重命名文件
        Path sourcesPath3 = Paths.get("src/main/resources/file_examples2/level1/file2_copy.txt");
        Path targetPath3 = Paths.get("src/main/resources/file_examples2/level1/file2_renamed.txt");
        try{
            Files.move(sourcesPath3,targetPath3);
            System.out.println("File renamed successfully -> " + targetPath3);
        } catch (IOException e) {
            System.out.println("Something went wrong ->");
            e.printStackTrace();
        }
    }
}
