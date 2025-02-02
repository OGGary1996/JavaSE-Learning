package b2_socket_multiChat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiChatServerSocketDemo implements Runnable {
    private final int portID;
    public MultiChatServerSocketDemo(int portID){
        this.portID = portID;
    }

    @Override
    public void run(){
        try (ServerSocket server = new ServerSocket(portID)){ // 使用try-with-resources语法糖，自动关闭资源
            System.out.println("Server: Server is running, waiting for client to connect...");
            while(true){
                Socket client = server.accept();
                System.out.println("Server: Client connected! IP: " + client.getInetAddress() + ", Port:" + client.getPort());
                // 每当有一个客户端连接，就创建一个新的线程来处理这个客户端的请求
                new Thread(new ClientHandle(client)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandle implements Runnable{
    private final Socket client;
    public ClientHandle(Socket client){
        this.client = client;
    }

    @Override
    public void run(){
        try (
            // 接收客户端的消息
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        ){
            while(true){
                String message = input.readLine();
                if (message.equalsIgnoreCase("exit")){
                    System.out.println("Server: Client disconnected!");
                    break;
                }
                System.out.println("Server received: " + message);
                // 向客户端发送确认消息
                output.write("Server received: " + message);
                output.newLine();
                output.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}