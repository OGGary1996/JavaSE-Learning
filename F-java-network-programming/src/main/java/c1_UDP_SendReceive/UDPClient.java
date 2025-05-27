package c1_UDP_SendReceive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient implements Runnable{
    private InetAddress serverIP;
    private int serverPort;
    public UDPClient(InetAddress serverIP, int serverPort){
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        // 1. Create a DatagramSocket object
        try (DatagramSocket client = new DatagramSocket();
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
        ){
            while(true){
                // 2. Read data from the console
                System.out.println("Please enter a message to send to the server('exit' to quit):");
                String sendMessage = reader.readLine();
                if (sendMessage.equalsIgnoreCase("exit")){
                    break;
                }
                // 3. send the data to the server
                    // 3.1 Construct a DatagramPacket object to send the data
                byte[] sendData = sendMessage.getBytes();
                    // 3.2 Construct a DatagramPacket object to send the data
                DatagramPacket sendPacket = new DatagramPacket(sendData,0,sendData.length,
                        serverIP,serverPort);
                    // 3.3 Send the data
                client.send(sendPacket);
                // 4. Receive the confirmation message from server
                    // 4.1 Create a buffer & DatagramPacket object to receive the confirmation message
                byte[] buffer = new byte[1024];
                DatagramPacket confirmPacket = new DatagramPacket(buffer,0,buffer.length);
                    // 4.2 Receive the confirmation message
                client.receive(confirmPacket);
                String confirmMessage = new String(confirmPacket.getData(),0,confirmPacket.getLength());
                System.out.println("Client: Received confirmation message from server -> " + confirmMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
