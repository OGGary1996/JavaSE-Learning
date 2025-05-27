package c_characterStream.b_bufferedRW;
// 本例子演示如何使用BufferedWriter和BufferedReader更加高效地写入和读取文件

import java.io.*;

public class a_BufferWriterReader {
    public static void main(String[] args) {
        // 创建需要读写操作的文件
        File file3 = new File("src/main/resources/file_examples/file3.txt");
        File parent = file3.getParentFile();
        if (!parent.exists()){
            parent.mkdirs();
        }
        try{
            if (!file3.exists()){
                file3.createNewFile();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        // 使用BufferedWriter写入文件
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file3))){
            // 使用bw中特有的方法newLine()插入换行符
            bw.write("This is wrote by BufferedWriter");
            bw.newLine();
            bw.write("This is another line, using newLine()");
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }

        // 使用BufferedReader读取文件
        try (BufferedReader br = new BufferedReader(new FileReader(file3))){
            // 使用br中特有的方法readLine()读取一行
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line); // 不包含换行符，手动换行
            }
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
