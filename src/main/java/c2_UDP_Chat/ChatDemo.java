package c2_UDP_Chat;

import java.net.InetAddress;

public class ChatDemo {
    public static void main(String[] args) {
        try {
            InetAddress senderOneIP = InetAddress.getLocalHost();
            InetAddress senderTwoIP = InetAddress.getLocalHost();
            int senderOnePort = 9999;
            int senderTwoPort = 8888;
            new Thread(new UDPSenderOne(senderOnePort,senderTwoIP,senderTwoPort)).start();
            new Thread(new UDPSenderTwo(senderTwoPort,senderOneIP,senderOnePort)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
