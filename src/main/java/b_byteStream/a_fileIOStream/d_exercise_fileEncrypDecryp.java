package b_byteStream.a_fileIOStream;
// 需求：实现文件的加密和解密
    // 加密：将文件中的内容进行加密处理，存储到新的文件中
    // 解密：将加密后的文件进行解密处理，存储到新的文件中

// 其中加密和解密的方式可以使用简单的异或运算
// 异或运算（二进制数据中，如果两个进行运算的元素在该位相同则结果为0，不相同结果为1）：
    // 1. 将文件中的每个字节与一个密钥进行异或运算
    // 2. 新的文件再次与同一个密钥进行异或运算，得到原文件

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class d_exercise_fileEncrypDecryp {
    private static final int key = 0xFF; // 密钥,10进制为255

    // 加密方法
    public static void encrypt(File file) throws IOException {
        if(file.isDirectory()){
            System.out.println("Cannot encrypt a directory");
            return;
        }
        // 使用fileIOStream进行加密
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(new File(file.getParentFile(),"Encrypted" + file.getName()));
        byte[] buffer = new byte[1024];
        int len;
        byte[] encrypted = new byte[1024];
        while((len = fis.read(buffer)) != -1){
            // 在每次读取完成之后，对读取到的字节进行异或运算，此时数据存储在buffer中
            for(int i = 0 ; i < len ; i++){
                encrypted[i] = (byte)(buffer[i] ^ key); //需要注意的是，异或运算的结果是int类型，所以需要强制转换为byte类型
            }
            // 储存结果之后，将结果写入到新的文件中
            fos.write(encrypted,0,len);
        }
    }

    // 解密方法
        public static void decrypt(File file) throws IOException {
        if(file.isDirectory()){
            System.out.println("Cannot encrypt a directory");
            return;
        }
        // 使用fileIOStream进行加密
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(new File(file.getParentFile(),"Decrypted" + file.getName()));
        byte[] buffer = new byte[1024];
        int len;
        byte[] decrypted = new byte[1024];
        while((len = fis.read(buffer)) != -1){
            // 在每次读取完成之后，对读取到的字节进行异或运算，此时数据存储在buffer中
            for(int i = 0 ; i < len ; i++){
                decrypted[i] = (byte)(buffer[i] ^ key); //需要注意的是，异或运算的结果是int类型，所以需要强制转换为byte类型
            }
            // 储存结果之后，将结果写入到新的文件中
            fos.write(decrypted,0,len);
        }
    }


    public static void main(String[] args) {
        File fileOrigin = new File("src/main/resources/file_examples/file6.txt");
        // 加密
        try {
            encrypt(fileOrigin);
        }catch (IOException e){
            System.out.println("Something went wrong -> ");
            e.printStackTrace();
        }
        // 解密
        File fileEncrypted = new File("src/main/resources/file_examples/Encryptedfile6.txt");
        try {
            decrypt(fileEncrypted);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
