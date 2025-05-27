package b_byteStream.a_fileIOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 使用FileIOStream实现文件复制，本例子使用File4来进行复制
// 使用FileInputStream从File4中读取，然后使用FileOutputStream将读取到的内容写入到File5中
// 如果File5此时不存在，则创建一个新的File5，不用提前创建
public class b_exercise_copyFile {
    public static void main(String[] args) {
        String sourcePath = "src/main/resources/file_examples/file4.txt";
        String targetPath = "src/main/resources/file_examples/file5.txt";
        try(
            FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(targetPath)
        ){
            // 使用read(byte[]),一次性读取多个字节到字符数组中
            byte[] data = new byte[1024]; // 共计1024个字节，1kb
            int bytesRead;
            while((bytesRead = fis.read(data)) != -1){ // 读取数据
                fos.write(data,0,bytesRead); // 将读取到的数据写入到目标文件中,指定为0到bytesRead的范围，不包括自动补位的数据
            }
            System.out.println("File copied successfully from " + sourcePath + " to " + targetPath);
        }catch(IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }
    }
}
