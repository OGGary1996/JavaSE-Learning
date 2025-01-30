package inetAddress;

// 本例子介绍 InetAddress 类的中的isReachable方法

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class d_ReachAble {
    public static void main(String[] args) {
        // 判断是否能够连接，返回布尔值
        try{
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("Attempting to reach: " + google.getHostAddress());
            if (google.isReachable(5000)){ // 可以设置时间上限
                System.out.println("Google is reachable within 5 seconds");
            }else{
                System.out.println("Google is not reachable within 5 seconds");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        // 如果isReachable方法失败，可能是因为系统权限问题，可以使用Process Builder类来解决,直接调用系统层级的ping命令
        try {
            System.out.println("Attempting to reach Google using ProcessBuilder");
            ProcessBuilder processBuilder;
            InetAddress google = InetAddress.getByName("www.google.com");
            // 判断系统类型
            if(System.getProperty("os.name").toLowerCase().contains("win")){
                processBuilder = new ProcessBuilder("cmd.exe", "/c", "ping -n 1 " + google.getHostAddress());
            }else{
                processBuilder = new ProcessBuilder("ping", "-c 1", google.getHostAddress());
            }
            // 启动进程
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
            // 等待进程结束
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
