package training.tutorialAdvanced.b_API;

// Java Runtime API

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b_Runtime {
    public static void main(String[] args) {
        // 1.由于使用单例模式，只能通过getRuntime()方法获取实例
        Runtime runtime = Runtime.getRuntime();
        // 2.获取系统资源
            // 2.1 获取CPU可用的线程核心数
        System.out.println("Available processors: " + runtime.availableProcessors());
            // 2.2 获取JVM内存相关的信息, 监控JVM的内存使用情况，避免OutOfMemoryError
        System.out.println("Total memory of JVM: " + runtime.totalMemory()/1024/1024 + "MB"); // JVM的总内存
        System.out.println("Free memory of JVM: " + runtime.freeMemory()/1024/1024 + "MB"); // JVM的空闲内存
        System.out.println("Maximum memory of JVM: " + runtime.maxMemory()/1024/1024 + "MB"); // JVM的最大内存

        // 3.运行外部程序
            // 3.1 执行命令行命令
        try {
            Process process = null;
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
               process = runtime.exec("cmd /c dir"); // Windows系统
            }else{
                process = runtime.exec("ls"); // Linux/MacOS系统
            }
            // 3.2 通过BufferedReader读取命令行的输出
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String scriptLine;
            while ((scriptLine = br.readLine()) != null){
                System.out.println(scriptLine);
            }
            br.close();
            process.destroy(); // 销毁进程
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
