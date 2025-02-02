package b2_socket_multiChat;

import b1_socket_chat.ServerSocketDemo;
import b1_socket_chat.SocketDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MultiChatDemo {
    public static void main(String[] args) {
        // 创建多线程环境，同时运行ServerSocketDemo和SocketDemo
        try{
            int portID = 9999;
            InetAddress address = InetAddress.getLocalHost();

            new Thread(new MultiChatServerSocketDemo(portID)).start();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new MultiChatSocketDemo(portID, address)).start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
