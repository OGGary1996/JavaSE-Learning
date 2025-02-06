package c1_UDP_SendReceive;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SendReceiveDemo {
    public static void main(String[] args) {
        try{
            InetAddress serverIP = InetAddress.getLocalHost();
            int serverPort = 9999;

            ExecutorService pool = Executors.newFixedThreadPool(2);
            pool.submit(new UDPServer(9999));
            pool.submit(new UDPClient(serverIP,9999));
            pool.shutdown();
            if(!pool.awaitTermination(60, TimeUnit.SECONDS)){
                pool.shutdownNow();
            }
        } catch (UnknownHostException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
