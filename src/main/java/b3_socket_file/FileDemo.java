package b3_socket_file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;

public class FileDemo {
    public static void main(String[] args) {
        // 创建需要传递的文件并且写入内容
        try {
            File file = new File("src/main/resources/source/test.txt");
            File parent = file.getParentFile();
            if (!parent.exists()){
                parent.mkdirs();
            }
            file.createNewFile();
            // 写入文件内容
            BufferedOutputStream dataOutput = new BufferedOutputStream(new FileOutputStream(file));
            dataOutput.write("This is a test file".getBytes());
            dataOutput.flush();
            dataOutput.close();
            System.out.println("File created successfully.");

            Thread.sleep(1000);

            int portID = 9999;
            InetAddress serverAddress = InetAddress.getLocalHost();

            Thread server = new Thread(new FileServerSocket(portID));
            server.join();
            server.start();
            Thread.sleep(1000);

            Thread client = new Thread(new FileSocket(portID, serverAddress, file));
            client.join();
            client.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
