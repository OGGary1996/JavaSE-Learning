package b_byteStream.c_serializationStream;

import java.io.*;

public class b_ObjectInputStream {
    public static Object deserialization(File file) throws IOException, ClassNotFoundException {
        // InputStream流读取文件时，文件必须存在
        if (!file.exists()){
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        // 创建ObjectInputStream对象,并将文件中的对象反序列化到内存中
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object obj = ois.readObject(); // 读取对象
        ois.close();
        return obj;
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/file_examples/Player.bin");
        try {
            Player p = (Player)deserialization(file);
            System.out.println("Deserialization successful!");
            System.out.println(p); // 反序列化后，调用toString()方法
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
