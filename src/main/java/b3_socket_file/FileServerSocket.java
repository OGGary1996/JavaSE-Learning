package b3_socket_file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServerSocket implements Runnable{
    private final int portID;
    public FileServerSocket(int portID){
        this.portID = portID;
    }

    @Override
    public void run(){
        try (
            ServerSocket server = new ServerSocket(portID)
        ){
            System.out.println("Server is running...");
            while(true){
                Socket client = server.accept();
                new Thread(new FileClientHandler(client)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class FileClientHandler implements Runnable{
    private final Socket client;
    // 初始化接收的文件路径
    private final String filePath = "src/main/resources/target/";
    public FileClientHandler(Socket client){
        this.client = client;
    }

    @Override
    public void run(){
        try (
            // 首先使用DataInputStream读取文件名称,避免与二进制文件内容冲突
            DataInputStream nameInput = new DataInputStream(client.getInputStream());
            // 使用BufferedInputStream读取文件中的数据
            BufferedInputStream dataInput = new BufferedInputStream(client.getInputStream());
        ){
            // 读取文件名称,并创建文件
            String fileName = nameInput.readUTF();
            File file_copy = new File(filePath+fileName);
            File parent = file_copy.getParentFile();
            if (!parent.exists()){
                parent.mkdirs();
            }
            file_copy.createNewFile();
            // 接收Socket传入的文件内容,并且写入文件中
            // 使用BufferedOutputStream将文件写入到本地
            BufferedOutputStream dataOutput = new BufferedOutputStream(new FileOutputStream(file_copy.getAbsolutePath()));
            byte[] buffer = new byte[1024];
            int length;
            while((length = dataInput.read(buffer)) != -1){
                dataOutput.write(buffer,0,length);
                dataOutput.flush();
            }
            System.out.println("File received -> " + file_copy.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}