package c2_UDP_Chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSenderOne implements Runnable{
    private int localPort;
    private int targetPort;
    private InetAddress targetIP;
    public UDPSenderOne(int localPort, InetAddress targetIP, int targetPort){
        this.localPort = localPort;
        this.targetIP = targetIP;
        this.targetPort = targetPort;
    }

    @Override
    public void run(){
        try(DatagramSocket send = new DatagramSocket();
        DatagramSocket receive = new DatagramSocket(localPort);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                // prepare for sending
                System.out.println("Please enter a message to send to the other('bye' to quit):");
                String sendMsg = userInput.readLine();
                DatagramPacket sendPacket = new DatagramPacket(sendMsg.getBytes(),0,sendMsg.getBytes().length,
                        targetIP,targetPort);
                send.send(sendPacket);
                System.out.println("Message sent successfully!");
                if (sendMsg.equalsIgnoreCase("bye")){
                    break;
                }
                // prepare for receiving
                byte[] buffer = new byte[1024];
                DatagramPacket receivedPacket = new DatagramPacket(buffer,0,buffer.length);
                receive.receive(receivedPacket);
                String receivedMsg = new String(receivedPacket.getData(),0,receivedPacket.getLength());
                System.out.println("Received from other -> " + receivedMsg);
                if (receivedMsg.equalsIgnoreCase("bye")){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
