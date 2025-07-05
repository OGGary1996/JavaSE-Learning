package d_lock;

// 本例子模拟配置读取和更新系统，多个线程读取配置，少数线程更新配置。

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ConfigCenter {
    private HashMap<String,String> configMap = new HashMap<>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock readLock = rwLock.readLock();
    Lock writeLock = rwLock.writeLock();
    // 初始化配置中心
    public ConfigCenter() {
        configMap.put("Default key","Default Config");
    }

    // 读配置
    public String readConfig(String key) throws InterruptedException {
        // 首先获取读锁
        try{
            readLock.lock();
            if (configMap.containsKey(key)){ // 如果存在该key，则模拟读取操作和耗时
                System.out.println(Thread.currentThread().getName() + " is reading config: " + key);
                Thread.sleep(500);// 模拟读取操作耗时
                System.out.println(Thread.currentThread().getName() + " has read config: "
                        + key + "->" + configMap.get(key));
                return configMap.get(key);
            }else{
                System.out.println(Thread.currentThread().getName() + " failed to read config: " + key);
                return null;
            }
        }finally {
            readLock.unlock();
        }
    }

    // 写配置
    public boolean writeConfig(String key,String value) throws InterruptedException {
        // 获取写锁
        try{
            writeLock.lock();
            if (configMap.containsKey(key)){ // 如果已经包含了该key，则提示覆盖value
                System.out.println(Thread.currentThread().getName() + " is ready to write config: " + key
                        + ", but this key is already exists, config will be replaced!" );
            }
            // 模拟写操作和耗时
            System.out.println(Thread.currentThread().getName() + " is writing config: " + key);
            Thread.sleep(1000);// 模拟写操作耗时
            if(configMap.put(key,value) != null){
                System.out.println(Thread.currentThread().getName() + " has written config: "
                        + key + "->" + value);
                return true;
            }else{
                System.out.println(Thread.currentThread().getName() + " failed to write config: " + key);
                return false;
            }
        }finally {
            writeLock.unlock();
        }
    }
}

// 线程类
class ReadTask implements Callable<String>{
    private final ConfigCenter configCenter;
    private final String key;
    public ReadTask(ConfigCenter configCenter,String key) {
        this.configCenter = configCenter;
        this.key = key;
    }

    @Override
    public String call() {
        try {
            return configCenter.readConfig(key);
        }catch (InterruptedException e){
            e.printStackTrace();
            return null;
        }
    }
}

class WriteTask implements Callable<Boolean>{
    private final ConfigCenter configCenter;
    private final String key;
    private final String value;
    public WriteTask(ConfigCenter configCenter,String key,String value) {
        this.configCenter = configCenter;
        this.key = key;
        this.value = value;
    }

    @Override
    public Boolean call(){
        try{
            return configCenter.writeConfig(key,value);
        }catch (InterruptedException e){
            e.printStackTrace();
            return false;
        }
    }
}

public class c_ReadWriteLock {
    public static void main(String[] args) {
        // 创建配置中心对象
        ConfigCenter configCenter = new ConfigCenter();

        // 创建线程
            // 1. 读线程,通过循环创建多个读线程
        for (int i = 0; i < 10; i++) {
            String key = "key" + i;
            ReadTask readTask = new ReadTask(configCenter, key);
            FutureTask<String> futureTask = new FutureTask<>(readTask);
            Thread readThread = new Thread(futureTask);
            readThread.start();
            // 读取结果

        }
            // 2. 写线程,通过循环创建多个写线程
        for(int i = 0 ; i < 3 ; i++){
            String key = "key" + i;
            String value = "value" + i;
            FutureTask<Boolean> writeTask = new FutureTask<>(new WriteTask(configCenter,key,value));
            Thread writeThread = new Thread(writeTask);
            writeThread.start();
        }
        // 等待线程结束

    }
}
