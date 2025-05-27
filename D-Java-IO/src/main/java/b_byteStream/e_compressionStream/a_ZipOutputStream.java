package b_byteStream.e_compressionStream;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// ZipStream是用于压缩的流，属于字节流的一种。
// 压缩的流程本质上是包含了两个过程，读取和写入：
    // 1. 首先将为要压缩的文件创建ZipEntry对象,并将这个对象添加到ZipOutputStream中。
    // 2. 是先使用普通字节流读取文件，将文件内容写出到压缩文件中。
// 创建ZipEntry的操作是必须的，如果不定义ZipEntry对象，输出流无法区分不同文件的内容，也无法设置文件名等属性。

public class a_ZipOutputStream {
    // 压缩单个文件
    public static void compression(File file,File destFile) throws IOException {
        if (file.isDirectory() || !file.exists()) {
            System.out.println("压缩失败,请检查文件是否存在");
            return;
        }
        File parent = destFile.getParentFile();
        if (!parent.exists()){
            parent.mkdirs();
        }
        // 创建普通的字节流用于读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        // 创建压缩流,传递压缩文件的路径
        ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(destFile)));
        // 创建ZipEntry对象,传递要压缩的文件名,只能传递文件名,不能传递路径
        ZipEntry entry = new ZipEntry(file.getName());
        // 将ZipEntry对象添加到压缩流中
        zos.putNextEntry(entry);
        // 读取文件,并写入压缩流中
        int len;
        byte[] data = new byte[1024];
        while((len = bis.read(data)) != -1){
            // 在每次循环中，将读取到的数据写入压缩流中
            zos.write(data,0,len);
        }
        // 关闭资源
        zos.closeEntry();
        zos.close();
        bis.close();
    }

    public static void main(String[] args) {
        File file1 = new File("src/main/resources/file_examples/file1.txt");
        File destFile = new File("src/main/resources/file1.zip");
        try {
            compression(file1,destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
