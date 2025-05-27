package d_Apache_Commons_IO;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// IOUtils是Apache Commons IO中的一个类，提供了对输入输出流的操作方法。
public class b_IOUtils {
    public static void main(String[] args) {
        // 1. copy(InputStream input, OutputStream output) 复制输入流到输出流
        try (
                FileInputStream fis = new FileInputStream("src/main/resources/file_examples/file8.bin");
                FileOutputStream fos = new FileOutputStream("src/main/resources/file_examples/file8_copy.bin")){
            IOUtils.copy(fis,fos);
        }catch(IOException e){
            System.out.println("复制文件失败");
            e.printStackTrace();
        }

        // 2. toByteArray(InputStream input) 将输入流转换为字节数组
        // 3. toString(InputStream input, String encoding) 将输入流转换为字符串
        // 4. readLines(InputStream input, String encoding) 读取输入流的所有行
    }
}
