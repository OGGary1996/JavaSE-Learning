package inetAddress;

// 本例子介绍 InetAddress 类的中根据 IP 地址获取 IP 地址和名称

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class c_getByAddress {
    public static void main(String[] args) {
        // 根据 IP 地址解析出对应的 IP 地址和名称,这里使用局域网中的razerBlade 14,已知其IP地址为10.0.0.253
        // getByAddress方法需要传入一个byte数组，长度为4,代表IPv4地址
        try{
            byte[] razerBladeAddress = new byte[]{(byte)10,(byte)0,(byte)0,(byte)253};
            InetAddress razerBlade = InetAddress.getByAddress(razerBladeAddress);
            System.out.println("Razer Blade's host name: " + razerBlade.getHostName());
            System.out.println("Razer Blade's IP address: " + razerBlade.getHostAddress());
            System.out.println("Attempting to reach: " + razerBlade.getHostAddress());
            if (razerBlade.isReachable(5000)){
                System.out.println("Razer Blade is reachable within 5 seconds");
            }else{
                System.out.println("Razer Blade is not reachable within 5 seconds");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        // 如果isReachable方法失败，可能是因为系统权限问题，可以使用Process Builder类来解决,直接调用系统层级的ping命令
        try{
            System.out.println("Attempting to reach Razer Blade using ProcessBuilder");
            ProcessBuilder processBuilder;
            byte[] razerBladeAddress = new byte[]{(byte)10,(byte)0,(byte)0,(byte)253};
            InetAddress razerBlade = InetAddress.getByAddress(razerBladeAddress);

            // 判断系统类型
            if (System.getProperty("os.name").toLowerCase().contains("win")){
                processBuilder = new ProcessBuilder("cmd.exe", "/c", "ping -n 1 " + razerBlade.getHostAddress());
            }else{
                processBuilder = new ProcessBuilder("ping", "-c 1", razerBlade.getHostAddress());
            }
            // 启动进程
            Process process = processBuilder.start();
            // 读取进程输出
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
