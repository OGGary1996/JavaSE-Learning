package c_characterStream.c_conversionStream;

// 在一些实际开发中，例如网络编程中，我们需要讲二进制数据转换为字符数据；为了避免乱码，和高效读取，使用转换流
    // 在这个例子中，我们使用转换流 + 缓冲流组合进行高效的读取，并显示信息

import java.io.*;

public class b_InputStreamReader {
    public static void readMessage(File file)throws IOException {
        // 输入流不会自动创建文件，所以我们需要判断文件是否存在，如果不存在则直接返回;
        // 此处我们选择如果文件不存在，退出方法，并手动抛出异常
        if (!file.exists()) {
            throw new IOException("文件不存在，请检查文件路径！");
        }
        // 使用FileInputStream + InputStreamReader + BufferedReader组合进行高效的读取
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(isr);
        // 读取数据
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line); // 打印读取到的数据,此时不包括换行符，需要手动换行
        }
    }

    public static void main(String[] args) {
        File file8 = new File("src/main/resources/file_examples/file8.bin");
        try {
            readMessage(file8);
        }catch (IOException e){
            System.out.println("文件读取失败");
            e.printStackTrace();
        }
    }
}
