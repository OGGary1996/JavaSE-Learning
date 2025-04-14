package d_threadSafetyCollections;

// 本例通过在外部创建模拟类和runnable类，演示如何使用CopyOnWriteArray
    // 与c1的例子不同的是，读操作会打印整个数组，而不是单个元素；然后写操作会随机修改数组中的一个元素；接着读操作会再次打印整个修改后的数组

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d2_CopyOnWriteArray {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.simulation();
    }
}

class Simulation {
    // create a CopyOnWriteArray
    private final CopyOnWriteArrayList<Integer> nums;
    public Simulation(){
        this.nums = new CopyOnWriteArrayList<>();
        this.nums.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
    }

    public void simulation(){
        // create Threads
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1 ; i <= 9 ; i++){
            executor.submit(new WriteTask(nums));
        }
        executor.submit(new ReadTask(nums));

        // shut down the executor
        executor.shutdown();
    }
}

class ReadTask implements Runnable{
    private final CopyOnWriteArrayList<Integer> nums;
    public ReadTask(CopyOnWriteArrayList<Integer> nums){
        this.nums = nums;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Read: " + nums);
        }
    }
}

class WriteTask implements Runnable{
    private final CopyOnWriteArrayList<Integer> nums;
    private final Random random = new Random();
    public WriteTask(CopyOnWriteArrayList<Integer> nums){
        this.nums = nums;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            /*
             * random.nextInt(nums.size())方法返回一个随机数，这个随机数是int类型的，范围是[0,nums.size())，对应key的范围
             * random.nextInt()方法返回一个随机数，这个随机数是int类型的，范围是int的取值范围，对应value的范围
             */
            nums.set(random.nextInt(nums.size()),random.nextInt());
        }
    }
}