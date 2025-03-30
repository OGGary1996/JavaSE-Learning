package b_byteStream.b_bufferedIOStream;

// 本例子通过BufferedInputStream和BufferedOutputStream演示如何更加高效地读取和写入二进制文件

import java.io.*;

public class a_BufferedInputOutputStream {
    public static void main(String[] args) {
        // 创建需要被写入的文件对象,本例子采用.bin文件格式，这种格式是二进制文件格式，可以存储任何数据
        File file5 = new File("src/main/resources/file_examples/file5.bin");
        File parent = file5.getParentFile();
        if(!parent.exists()){
            parent.mkdirs();
        }
        try{
            if (file5.createNewFile()){
                System.out.println("File created successfully -> " + file5.getAbsolutePath() + file5.getName());
            }else{
                System.out.println("File created failed, maybe it already exists -> " + file5.getAbsolutePath() + file5.getName());
            }
        }catch(Exception e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }

        // 通过BufferedOutputStream写入文件
        try{
            // 1. 创建BufferedOutputStream对象,创建这个对象必须使用try-catch块或者throws IOException
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/main/resources/file_examples/file5.bin"));
            // 2. 使用write()方法写入文件,write()方法接收byte[]数组作为参数
            String data = "BufferedOutputStream is more efficient than FileOutputStream";
            bos.write(data.getBytes());
            bos.flush(); // 刷新缓冲区
            // 3. 关闭流
            bos.close();
        }catch(IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }

        // 通过BufferedInputStream读取文件
        try{
            // 1. 创建BufferedInputStream对象,创建这个对象必须使用try-catch块或者throws IOException
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/main/resources/file_examples/file5.bin"));
            // 2. 读取文件,使用read()方法读取文件，返回读取的字节的ASCII码，如果到达文件末尾返回-1
            int data;
            while((data = bis.read()) != -1){
                System.out.println((char)data);
            }
            // 3. 关闭流
        }catch(IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }
    }
}
