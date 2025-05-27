package b1_TCP_chat;

// 本例子演示如何创建一个简单的Socket客户端
// 并且发送消息给服务器

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketDemo implements Runnable{
    private final int portID;
    private final InetAddress address;

    public SocketDemo(int portID, InetAddress address){
        this.portID = portID;
        this.address = address;
    }
    @Override
    public void run() {
        // 1. 创建一个Socket对象，并且指定服务器的IP地址和端口号
        try{
            System.out.println("Client: Connecting to server...");
            Socket client = new Socket(address.getHostAddress(), portID);
            System.out.println("Client: Connected to server, server IP: " + address.getHostAddress() + ", Port: " + portID);
            // 2. 向服务器发送消息,类似于第一次握手，发送消息
                // 本例子主要传递的信息是字符串，所以使用BufferedWriter更加高效，如果传递的是二进制文件，可以使用DataOutputStream
                // BufferedWriter 接受参数类型必须为Writer类型，所以使用OutputStreamWriter将OutputStream转换为Writer
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            output.write("Hello Server, I am Client!");
            output.newLine(); // 必须加上这一行，否则Server端的BufferedReader无法读取到换行符则会一直阻塞不回读取到消息
            output.flush();

            // 3. 接收Server发送的确认消息
                // 同样使用的是BufferedReader
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Client : Server message received -> " + input.readLine());
            // 4.关闭流和Socket
            input.close();
            output.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
