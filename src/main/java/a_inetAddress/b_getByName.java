package a_inetAddress;

// 本例子介绍 InetAddress 类的中根据域名获取 IP 地址和名称

import java.net.InetAddress;
import java.net.UnknownHostException;

public class b_getByName {
    public static void main(String[] args) {
        // 根据域名解析出对应的 IP 地址和名称
        try{
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("Google's Host name: " + google.getHostName());
            System.out.println("Google's IP address: " + google.getHostAddress());
        }catch(UnknownHostException e){
            e.printStackTrace();
        }

        // 获取域名的所有ip,返回InetAddress的对象数组
        try{
            InetAddress[] netFlix = InetAddress.getAllByName("www.netflix.com");
            System.out.println("Following are the IP addresses of NetFlix");
            for(InetAddress address : netFlix){
                System.out.println(address.getHostAddress());
            }
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
}
