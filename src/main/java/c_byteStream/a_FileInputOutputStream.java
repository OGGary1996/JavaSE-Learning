package c_byteStream;

// 本例子演示如何使用FileInputStream和FileOutputStream写入和读取文件

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class a_FileInputOutputStream {
    public static void main(String[] args) {
        // 创建需要被写入的文件对象,本例子采用.bin文件格式，这种格式是二进制文件格式，可以存储任何数据
        File file4 = new File("src/main/resources/file_examples/file4.bin");
        File parent = file4.getParentFile();
        if (!parent.exists()){
            parent.mkdirs();
        }
        try{
            if (file4.createNewFile()){
                System.out.println("File created successfully -> " + file4.getAbsolutePath() + file4.getName());
            }else{
                System.out.println("File created failed, maybe it already exists -> " + file4.getAbsolutePath() + file4.getName());
            }
        }catch(Exception e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }

        // 通过FileOutputStream写入文件
        try{
            // 1. 创建FileOutputStream对象,创建这个对象必须使用try-catch块或者throws IOException
            FileOutputStream fos = new FileOutputStream("src/main/resources/file_examples/file4.bin");
            // 2. 使用write()方法写入文件,这个方法可以传递单个int参数，或者byte Array；这里写入的是ASCII码
            fos.write(65); // A
            fos.write(new byte[]{66, 67, 68, 69, 70}); // B,C,D,E,F
            // 3. 关闭流
            fos.close();
        }catch(IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }

        // 通过FileInputStream读取文件
        try{
            // 1. 创建FileInputStream对象,创建这个对象必须使用try-catch块或者throws IOException
            FileInputStream fis = new FileInputStream("src/main/resources/file_examples/file4.bin");
            // 2. 读取文件,使用read()方法读取文件，返回读取的字节的ASCII码，如果到达文件末尾返回-1
            int data;
            while((data = fis.read()) != -1){
                System.out.print((char)data);
            }
            System.out.println();
            // 3. 关闭流
            fis.close();
        }catch(IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }
    }
}
