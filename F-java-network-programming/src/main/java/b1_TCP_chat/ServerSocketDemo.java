package b1_TCP_chat;

// 本例子演示如何创建一个简单的Socket服务器
// 并且接收客户端class接收消息

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo implements Runnable{
    private final int portID;

    public ServerSocketDemo(int portID){
        this.portID = portID;
    }
    @Override
    public void run() {
        // 1. 创建一个ServerSocket对象,并且绑定一个端口
        try{
            ServerSocket server = new ServerSocket(portID);
            System.out.println("Server: Server is running, waiting for client to connect...");
            // 2. 调用accept方法等待客户端连接
            System.out.println("Server: Server is waiting for client to connect...");
            Socket client = server.accept();
            System.out.println("Server: Client connected! IP: " + client.getInetAddress() + ", Port: " + client.getPort());
            // 3. 从Socket中获取输入流,并且打印客户端发送的消息，类似于第二次握手，接收消息
                // 本例子主要接收的信息是字符串，所以使用BufferedReader更加高效，如果传递的是二进制文件，可以使用DataInputStream
                // BufferedReader 接受参数类型必须为Reader类型，所以使用InputStreamReader将InputStream转换为Reader
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Server: Client message -> " + input.readLine());
            // 4.向客户端发送消息确认收到，类似于第三次握手，发送确认消息
                // 同样使用的是BufferedWriter
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            output.write("Hey Client, message received!");
            output.newLine(); // 必须加上这一行，否则Client端的BufferedReader无法读取到换行符则会一直阻塞不回读取到消息
            output.flush();
            // 5.关闭流和Socket
            input.close();
            output.close();
            client.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
