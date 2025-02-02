package b1_socket_chat;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try{
            int portID = 9999;
            InetAddress address = InetAddress.getLocalHost();

            // 创建多线程环境，同时运行ServerSocketDemo和SocketDemo
            new Thread(new ServerSocketDemo(portID)).start();
            new Thread(new SocketDemo(portID, address)).start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
