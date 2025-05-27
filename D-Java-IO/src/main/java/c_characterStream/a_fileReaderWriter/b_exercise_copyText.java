package c_characterStream.a_fileReaderWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class b_exercise_copyText {
    public static void main(String[] args){
        String path = "src/main/resources/file_examples/file6.txt";
        String target = "src/main/resources/file_examples/file7.txt";
        // 1. 创建文件对象，如果使用FileReader时，文件不存在，则会抛出FileNotFoundException
        File file = new File(path);
        if (!file.exists()){
            File parent = file.getParentFile();
            if (!parent.exists()){
                parent.mkdirs();
            }
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println("Something went wrong -> ");
                e.printStackTrace();
            }
        }

        // 2.使用FileReader + FileWriter复制文本
        try (FileReader fr = new FileReader(path);
             FileWriter fw = new FileWriter(target)
        ){
            char[] buffer = new char[1024]; // 1MB的缓冲区
            int len;
            while((len = fr.read(buffer)) != -1){
                fw.write(buffer,0,len);
            }
            System.out.println("File copied successfully from " + path + " to " + target);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
