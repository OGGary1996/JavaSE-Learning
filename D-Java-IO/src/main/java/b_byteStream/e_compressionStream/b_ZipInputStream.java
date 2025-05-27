package b_byteStream.e_compressionStream;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// ZipInputStream是用于解压缩的流，属于字节流的一种。
// 解压缩的流程也包含了读写的过程：
    // 1. 使用ZipEntry对象读取压缩文件中的每一个文件。
    // 2. 使用普通字节流读取文件，将文件内容写出到指定目录中。
// 获取ZipEntry对象的步骤是必须的，如果不调用 getNextEntry()，你无法访问 ZIP 文件中的内容，因为流需要知道当前应该解压缩哪个条目。

public class b_ZipInputStream {
    public static void decompression(File zipFile,File destDir) throws IOException {
        // 判断压缩文件是否存在
        if (!zipFile.exists() || !destDir.isDirectory()){
            System.out.println("压缩文件或指定目录不存在");
            return;
        }
        // 创建ZipInputStream对象,传递压缩文件的路径
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        // 创建ZipEntry对象,用于读取压缩文件
        ZipEntry entry = zis.getNextEntry();
        // 创建普通的字节流用于写出文件
        BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream(new File(destDir,"UnZip" + entry.getName())));
        // 写出文件到指定目录
        int len;
        byte[] data = new byte[1024];
        while((len = zis.read(data)) != -1){
            bis.write(data,0,len);
        }
        // 关闭资源
        bis.close();
        zis.closeEntry();
        zis.close();
    }

    public static void main(String[] args) {
        File file1 = new File("src/main/resources/file1.zip");
        File destDir = new File("src/main/resources");
        try {
            decompression(file1,destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
