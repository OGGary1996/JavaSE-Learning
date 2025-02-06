package c1_UDP_SendReceive;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer implements Runnable{
    private int portID;
    public UDPServer(int portID){
        this.portID = portID;
    }

    @Override
    public void run(){
        // 1. Create a DatagramSocket object
        try(DatagramSocket server = new DatagramSocket(portID)){
            System.out.println("Server is running on port: "+portID);
            while(true){ // continuously listen for incoming packets
                // 2.Create a buffer & DatagramPacket object to receive incoming packets
                byte[] buffer = new byte[1024];
                DatagramPacket receivedPacket = new DatagramPacket(buffer, 0,buffer.length);
                // 3. Receive incoming packets
                server.receive(receivedPacket);
                String receivedData = new String(receivedPacket.getData(),0,receivedPacket.getLength());
                if (receivedData.equalsIgnoreCase("exit")){
                    break;
                }
                // 4. Launch a new Thread for each incoming packet
                new Thread(new PacketHandler(server,receivedPacket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
    以下的线程类用于处理单个接收到的数据包，每个数据包都会启动一个线程；
    与TCP服务器端不同的是，这里不会使用while循环来处理多个客户端的连接，因为UDP是无连接的；这里只是处理单个数据包，处理完毕后线程结束。
 */
class PacketHandler implements Runnable{
    private DatagramSocket server; // 传入server对象，用于发送确认数据给客户端
    private DatagramPacket receivedPacket;
    public PacketHandler(DatagramSocket server, DatagramPacket receivedPacket){
        this.server = server;
        this.receivedPacket = receivedPacket;
    }

    @Override
    public void run(){
        // 5。Extract the data from the received packet
        String receivedData = new String(receivedPacket.getData(),0,receivedPacket.getLength());
        System.out.println("Server: Received data from client -> " + receivedData);
        // 6. Send a confirmation message to the client
            // 6.1 Construct the confirmation message
        byte[] confirmData = "Server has received your message!".getBytes();
            // 6.2 Construct a DatagramPacket object to send the confirmation message
        DatagramPacket confirmPacket = new DatagramPacket(confirmData,0,confirmData.length,
                receivedPacket.getAddress(),receivedPacket.getPort()); // as a response, must have the client's address and port
            // 6.3 Send the confirmation message
        try {
            server.send(confirmPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
