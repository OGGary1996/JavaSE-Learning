package b3_socket_file;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class FileSocket implements Runnable{
    private final int portID;
    private final InetAddress serverAddress;
    private final File file1;
    public FileSocket(int portID, InetAddress serverAddress, File file1) {
        this.portID = portID;
        this.serverAddress = serverAddress;
        this.file1 = file1;
    }

    @Override
    public void run(){
        try (
                // 1. Create a socket and connect to the server
                Socket client = new Socket(serverAddress.getHostAddress(), portID);
                // 使用DataOutputStream发送文件的名称,避免与二进制文件内容冲突
                DataOutputStream nameOutput = new DataOutputStream(client.getOutputStream());
                // 使用BufferedInputStream读取文件中的数据
                BufferedInputStream dataInput = new BufferedInputStream(new FileInputStream(file1.getAbsolutePath()));
                // 使用BufferedOutputStream发送文件中的数据
                BufferedOutputStream dataOutput = new BufferedOutputStream(client.getOutputStream());
        ){
            System.out.println("Client is running...");
            // 2. Send the file to the server
                // 发送文件的名称
            nameOutput.writeUTF(file1.getName());
            nameOutput.flush();
                // 读取文件中的数据，并发送数据
            System.out.println(file1.getName() + " file is sending...");
            byte[] buffer = new byte[1024];
            int length;
            while((length = dataInput.read(buffer)) != -1){
                dataOutput.write(buffer, 0, length);
                dataOutput.flush();
            }
            System.out.println(file1.getName() + " file sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
