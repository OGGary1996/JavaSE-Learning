package b_byteStream.c_serializationStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 将多个Player对象序列化到同一个文件中，并且使用反序列化进行查看
// 细节：
    // 1.如果单独为每个对象进行序列化和反序列化，那么如果不知道对象个数的情况下，无法使用while循环停止反序列化
    // 2.因为，如果反序列化时读取到文件末，不会像其他的流一样返回-1或者是null；而是直接抛出EOFException异常(end of file)
    // 3.所以，我们可以将所有的对象都存入集合中，并且针对一个集合进行序列化和反序列化，因为集合也属于Object

public class c_exercise {
    public static void serialization (List<? extends Player> list, File file) throws IOException {
        // 利用OutputStream写入文件时，文件可以不存在，但是父级目录必须存在
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs(); // 创建父级目录
        }
        // 创建ObjectOutputStream对象,并将对象序列化到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(list); // 将对象序列化到文件中
        System.out.println("序列化成功");
        oos.close(); // 关闭流
    }

    public static List<? extends Player> deserialization(File file) throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        // 创建ObjectInputStream对象,并将文件中的对象反序列化到内存中
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<? extends Player> list = (ArrayList<? extends Player>) ois.readObject();
        ois.close();
        return list; // 返回反序列化后的对象
    }



    public static void main(String[] args) {
        // 创建多个Player对象,ArrayList已经实现了Serializable接口
        List<Player> playerList = new ArrayList<>();
        Collections.addAll(playerList,
                new Player("ke", 18, "admin123123"),
                new Player("George", 20, "admin123123"),
                new Player("Tom", 22, "admin123123"),
                new Player("Jerry", 25, "admin123123"),
                new Player("Jack", 30, "admin123123"),
                new Player("Rose", 28, "admin123123"));
        File file = new File("./src/main/resources/file_examples/Multi-players.txt");
        // 序列化
        try {
            serialization(playerList,file);
            System.out.println("Serialization successful!");
        }catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化
        try {
            List<Player> resultSet = (ArrayList<Player>) deserialization(file);
            resultSet.forEach(System.out::println);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("反序列化失败");
            e.printStackTrace();
        }

    }
}
