package c_characterStream.a_fileReaderWriter;
// 需求：实现文本文件的排序
    // 文本中的数据为2-1-9-4-7-8
    // 将文本中的数据按照从小到大的顺序进行排序


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c_exercise_SortText {
    // 排序方法
    public static void sortText(File file) throws IOException {
        if (file.isDirectory()) {
            System.out.println("Cannot sort a directory");
            return;
        }
        // 1.读取出文件的数据
        FileReader fr = new FileReader(file);
        char[] data = new char[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while((len = fr.read(data)) != -1){
            // 2.将读取到的数据装载到StringBuilder中,因为只有String中可以进行分割字符串
            sb.append(data,0,len);
        }
        // 3.将StringBuilder转换为String，然后进行分割
        String str = sb.toString();
        String[] arrStr = str.split("-");
        // 4.将字符串数组使用stream，映射为Integer，然后进行排序，然后收集为Integer[]数组
        Integer[] arrInteger = Arrays.stream(arrStr)
                .map(Integer::parseInt)
                .sorted().toArray(Integer[]::new);
        // 5.将排序后的结果转换为String，并且添加-分隔符，作为最终我们需要传递的结果
        String text = Arrays.toString(arrInteger);// 结果是[1, 2, 4, 7, 8, 9]
            // 5.1 去掉[]和空格
        text.replace(", ","-").substring(0,text.length()-1);
        // 6.将排序后的结果写入到新的文件中
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.flush();
        fw.close();
        fr.close();
    }

    // 主方法
    public static void main(String[] args) {
        File file = new File("src/main/resources/file_examples/file7.txt");
        try {
            sortText(file);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
