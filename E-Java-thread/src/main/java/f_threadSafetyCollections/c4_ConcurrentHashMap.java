package f_threadSafetyCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// 本例子展示了如何使用ConcurrentHashMap来模拟cache的获取

class Cache {
    private final ConcurrentHashMap<String,String> cacheMap = new ConcurrentHashMap<>();

    // 获取方法
    public String getValue(String key) throws InterruptedException {
        // 如果缓存中没有这个kay，则从数据库中获取
        if(!cacheMap.containsKey(key)){
            return fetchFromDB(key);
        }else{ // 如果存在这个key，则直接提取
            System.out.println(Thread.currentThread().getName() + "is getting value from cache...");
            return cacheMap.get(key);
        }
    }

    // 模拟从数据库中获取数据
    public String fetchFromDB(String key) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "is fetching from DB...");
        Thread.sleep(2000);
        // 模拟生成Hashcode数据
        String value = Integer.toString(key.hashCode());
        // 将数据放入缓存中
        cacheMap.put(key,value);
        System.out.println(Thread.currentThread().getName() + "has fetched from DB.");
        return value;
    }
}

// 线程类
class Task implements Callable<String>{
    private final Cache cache;
    private final String key;

    public Task(Cache cache, String key) {
        this.cache = cache;
        this.key = key;
    }

    @Override
    public String call() throws InterruptedException {
        // 在线程逻辑中，模拟向cache中添加数据
        return cache.getValue(key);
    }
}

public class c4_ConcurrentHashMap {
    public static void main(String[] args) {
        Cache cachePool = new Cache();
        List<FutureTask<String>> futureTasks = new ArrayList<>();

        // 通过循环创建10个线程来模拟多线程环境
        for (int i = 0 ; i < 10 ; i++){
            String key = "Key @ " + i;
            FutureTask<String> fTask = new FutureTask<>(new Task(cachePool,key));
            futureTasks.add(fTask);
            new Thread(fTask).start();
        }

        // 获取线程的返回值
        for (FutureTask<String> fTask : futureTasks){
            try {
                String result = fTask.get();
                System.out.println(result);
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }


    }
}
