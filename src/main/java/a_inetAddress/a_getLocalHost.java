package a_inetAddress;

// 本例子主要介绍 InetAddress 类的基本使用
// InetAddress 类是 Java 网络编程的基础类，用于表示 IP 地址

import java.net.InetAddress;
import java.net.UnknownHostException;

public class a_getLocalHost {
    public static void main(String[] args) {
        // 获取本机的ip地址，localhost，返回的是一个InetAddress对象
        try{
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local host: " + localHost.getHostName());
            System.out.println("Local host address: " + localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // 根据域名获取ip地址和名称


    }
}
