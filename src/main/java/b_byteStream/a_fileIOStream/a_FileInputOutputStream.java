package b_byteStream.a_fileIOStream;

// 本例子演示如何使用FileInputStream和FileOutputStream写入和读取文件

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class a_FileInputOutputStream {
    public static void main(String[] args) {
        // 如果需要操作的文件不存在，则在IOStream的底层会通过路径创建新的File对象，所以事先创建文件这个操作不是必须的
        // 创建需要被写入的文件对象
        String path = "src/main/resources/file_examples/file4.txt";
        File file4 = new File(path);
        File parent = file4.getParentFile();
        if (!parent.exists()){
            parent.mkdirs();
        }
        try{
            file4.createNewFile();
            System.out.println("File created successfully -> " + file4.getAbsolutePath());
        }catch (IOException e) {
            e.printStackTrace();
        }

        // 通过FileOutputStream写入文件
            // try-with-resources
        try(
            FileOutputStream fos = new FileOutputStream(file4)
        ){
            fos.write("Hello, world!".getBytes());
            System.out.println("File write successfully!");
        }catch (IOException e) {
            e.printStackTrace();
        }

        // 通过FileInputStream读取文件
            // try-with-resources
        try(
            FileInputStream fis = new FileInputStream(file4);
        ){
            System.out.print("File content -> ");
//            int b;
//            while((b = fis.read()) != -1){
//                System.out.print((char)b);
//            }
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                System.out.println(new String(buffer, 0, len));
            }
            System.out.println();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
