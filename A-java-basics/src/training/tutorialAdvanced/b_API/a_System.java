package training.tutorialAdvanced.b_API;

// 一些常用的System类的API

import java.util.Scanner;

public class a_System {
    public static void main(String[] args) {
        // 1. System.out System.err System.in
            // 1.1 System.out ，是一个PrintStream对象，提供了打印输出的功能
        System.out.println("Hello, Java!"); // 输出并换行
        System.out.print("Hello, ");        // 输出但不换行
        System.out.print("World!\n");       // 需要手动换行
        System.out.printf("Pi: %.2f\n", Math.PI); // 格式化输出 Pi: 3.14
            // 1.2 System.err 与 System.out 类似，但是输出到错误流，
        System.err.println("This is an error message"); // 输出错误信息,
            // 1.3 System.in，是一个InputStream对象，提供了输入的功能，常用于读取键盘输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!"); // 输出用户输入的名字

        // 2. 事件相关
            // 2.1 System.currentTimeMillis() 返回当前时间到1970年1月1日 00:00:00 的毫秒数，返回long类型
        long currentTimeMills = System.currentTimeMillis();
        System.out.println("Current time in milliseconds since 1970: " + currentTimeMills);
            // 2.2 System.nanoTime() 返回当前时间到1970年1月1日 00:00:00 的纳秒数，返回long类型
        long currentTimeNanos = System.nanoTime();
        System.out.println("Current time in nanoseconds since 1970: " + currentTimeNanos);

        // 3.System.exit(int status) 退出程序，status为退出状态码，0表示正常退出，非0表示异常退出
            // 后续的所有代码都不会执行
        System.out.println("Program is running...");
        //System.exit(0); // 终止程序
        //System.out.println("This line will never execute.");

        // 4. 操作环境变量
            // 4.1 getenv(String name) 获取指定环境变量的值
        System.out.println(System.getenv("JAVA_HOME"));
            // 4.2 getProperties() 获取系统属性
        System.out.println(System.getProperty("os.name")); // 获取操作系统名称
        System.out.println(System.getProperty("os.version")); // 获取操作系统版本
        System.out.println(System.getProperty("java.version")); // 获取Java版本

        // 5. 拷贝数组,System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
            // 5.1 src: 源数组
            // 5.2 srcPos: 源数组的起始位置
            // 5.3 dest: 目标数组
            // 5.4 destPos: 目标数组的起始位置
            // 5.5 length: 拷贝的长度
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[10];
        System.arraycopy(src,0,dest,4,src.length);
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i] + " "); // 输出拷贝后的数组
        }


    }
}
