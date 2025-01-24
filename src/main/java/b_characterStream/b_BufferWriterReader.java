package b_characterStream;

// 本例子演示如何使用BufferedWriter和BufferedReader更加高效地写入和读取文件

import java.io.*;

public class b_BufferWriterReader {
    public static void main(String[] args) {
        // 创建需要读写操作的文件
        File file3 = new File("src/main/resources/file_examples/file3.txt");
        File parent = file3.getParentFile();
        if (!parent.exists()){
            parent.mkdirs();
        }
        try{
            if(file3.createNewFile()){
                System.out.println("File created successfully -> " + file3.getAbsolutePath() + file3.getName());
            }else{
                System.out.println("Failed to create file, maybe it already exists -> " + file3.getAbsolutePath() + file3.getName());
            }
        } catch (Exception e) {
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }

        // 使用BufferedWriter写入文件
        try{
            // 1. 创建BufferedWriter对象,需要传递一个FileWriter对象,
            // 创建这个对象必须使用try-catch块或者throws IOException,直接传递匿名对象避免使用关闭流
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/file_examples/file3.txt"));
            // 2. 使用write()方法写入文件
            bufferedWriter.write("Buffered Writer is more efficient than FileWriter");
            bufferedWriter.newLine(); // 换行
            bufferedWriter.write("Just print a new line");
            // 3. 关闭流
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }

        // 使用BufferedReader读取文件
        try{
            // 1. 创建BufferedReader对象,需要传递一个FileReader对象,
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/file_examples/file3.txt"));
            // 2. 读取文件,使用readLine()方法读取一整行，返回读取的字符串，如果到达文件末尾返回null
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            // 3. 关闭流
            bufferedReader.close();
        }catch(IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }
    }
}
