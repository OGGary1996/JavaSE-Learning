package b_byteStream.e_compressionStream;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class c_Exercise {
    // 压缩文件夹中的所有文件
        // 只创建一次压缩流
    public static void compression(File sourceDir, File destZipFile) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(destZipFile))) {
            compress(sourceDir, sourceDir.getName(), zos);
        }
    }
        // 主方法，压缩文件夹
    private static void compress(File file, String entryName, ZipOutputStream zos) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                // 空文件夹处理：创建条目，也就是在Zip文件夹中创建一个空文件夹
                zos.putNextEntry(new ZipEntry(entryName + "/"));
                zos.closeEntry();
            } else {
                // 非空文件夹递归处理
                for (File f : files) {
                    compress(f, entryName + "/" + f.getName(), zos);
                }
            }
        } else {
            // 文件压缩
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                zos.putNextEntry(new ZipEntry(entryName));
                byte[] buffer = new byte[1024];
                int len;
                while ((len = bis.read(buffer)) != -1) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
            }
        }
    }

    // 解压缩文件
        // 只创建一次解压缩流
    public static void decompress(File sourceZipFile, File destDir) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(sourceZipFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                File newFile = new File(destDir, entry.getName());
                if (entry.isDirectory()) { // 如果是目录，在目标目录中创建目录
                    newFile.mkdirs();
                } else { // 如果是文件，则进行解压操作
                    // 确保父目录存在
                    newFile.getParentFile().mkdirs();
                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile))) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) != -1) {
                            bos.write(buffer, 0, len);
                        }
                    }
                }
                zis.closeEntry();
            }
        }
    }


    public static void main(String[] args) {
        File sourceDir = new File("src/main/resources/file_examples");
        File destZipFile = new File("src/main/resources/compressed_folder.zip");

        try {
            compression(sourceDir, destZipFile);
            System.out.println("压缩成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
