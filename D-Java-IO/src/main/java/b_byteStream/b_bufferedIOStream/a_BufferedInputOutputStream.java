package b_byteStream.b_bufferedIOStream;

// 本例子通过BufferedInputStream和BufferedOutputStream演示如何更加高效地读取和写入二进制文件

import java.io.*;

public class a_BufferedInputOutputStream {
    public static void main(String[] args) {
        // 创建需要被写入的文件对象,本例子采用.bin文件格式，这种格式是二进制文件格式，可以存储任何数据
        File file5 = new File("src/main/resources/file_examples/file5.txt");
        File parent = file5.getParentFile();
        if (!parent.exists()){
            parent.mkdirs();
        }
        try {
            if (!file5.exists()){
                file5.createNewFile();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        // 通过BufferedOutputStream写入文件
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file5))){
            bos.write("Hello, world!".getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }

        // 通过BufferedOutputStream写入文件
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file5))){
            // 1.bis只是针对输入流的封装，真正底层的流还是是FileInputStream
            byte[] data = new byte[1024]; // 共计1024个字节，1kb
            int len;
            while((len = bis.read(data)) != -1){
                System.out.println(new String(data, 0, len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
