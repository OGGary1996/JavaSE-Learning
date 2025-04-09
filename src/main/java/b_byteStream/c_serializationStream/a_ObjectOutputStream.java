package b_byteStream.c_serializationStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class a_ObjectOutputStream {
    public static void serialization(Object obj, File file) throws IOException {
        // 利用OutputStream写入文件时，文件可以不存在，但是父级目录必须存在
        File parentDir = file.getParentFile();
        if (!parentDir.exists()){
            parentDir.mkdirs(); // 创建父级目录
        }
        // 创建ObjectOutputStream对象,并将对象序列化到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(obj); // 将对象序列化到文件中
        System.out.println("序列化成功");
        oos.close(); // 关闭流
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/file_examples/Player.bin");
        Player p = new Player("Ke", 18,"admin123123");
        try{
            serialization(p, file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
