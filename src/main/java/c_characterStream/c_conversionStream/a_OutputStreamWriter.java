package c_characterStream.c_conversionStream;

// 在一些实际开发中，例如网络编程中，我们需要讲二进制数据转换为字符数据；为了避免乱码，和高效读取，使用转换流
    // 在本例中，我们使用转换流 + 缓冲流组合进行高效的写入

import java.io.*;

public class a_OutputStreamWriter {
    public static void writeMessage(File file,String ... msgs) throws IOException {
        // 利用写出流遇到文件不存在会自动创建的特性，我们无序担心文件不存在的问题，但是需要保证父级目录存在
        File parent = file.getParentFile();
        if (!parent.exists()){
            parent.mkdirs(); // 创建父级目录
        }
        // 使用FileOutputStream + OutputStreamWriter + BufferedWriter组合进行高效的写入
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
        BufferedWriter bw = new BufferedWriter(osw);
        // 写入数据,由于要控制在最后一个索引未至不输入换行，所以使用带有索引表计的普通for循环
        for(int i = 0 ; i < msgs.length ; i++){
            bw.write(msgs[i]);
            if (i != msgs.length - 1){ // 如果不是最后一个索引，则需要添加换行
                bw.newLine();
            }
        }
        // 关闭流
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) {
        File file8 = new File("src/main/resources/file_examples/file8.bin");
        String msg1 = "这是第一条测试（中文）";
        String msg2 = "This is the second test (English)";
        String msg3 = "这是第三条测试（中文）";
        String msg4 = "This is the fourth test (English)";

        try {
            writeMessage(file8,msg1, msg2, msg3, msg4);
        }catch (IOException e){
            System.out.println("文件写入失败");
            e.printStackTrace();
        }
    }
}
