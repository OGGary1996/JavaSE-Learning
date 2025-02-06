package b2_TCP_multiChat;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MultiChatSocketDemo implements Runnable {
    private final int portID;
    private final InetAddress address;

    public MultiChatSocketDemo(int portID, InetAddress address){
        this.portID = portID;
        this.address = address;
    }

    @Override
    public void run(){
        // 创建一个Socket对象，并且指定服务器的IP地址和端口号
        try (Socket client = new Socket(address.getHostAddress(), portID);
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))){
            // 使用try-with-resources语法糖，自动关闭资源
            System.out.println("Client: Connected to server, IP: " + address.getHostAddress() + ", Port: " + portID);
            while(true){
                // 不间断发送消息给服务器
                System.out.println("Client: Please enter message to send, enter 'exit' to quit.");
                String message = consoleInput.readLine();
                if (message.equalsIgnoreCase("exit")){
                    output.write("exit");
                    output.newLine();
                    output.flush();
                    System.out.println("Client: Closing connection...");
                    break;
                }
                output.write(message);
                output.newLine();
                output.flush();

                // 不间断接收服务器的确认消息
                System.out.println("Client: Server message received -> " + input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
