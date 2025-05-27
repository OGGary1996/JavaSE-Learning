package f_threadSafetyCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a2_SynchronizedCollections {
    public static void main(String[] args) {
        /*
         *在使用Collections.synchronizedList()方法时，我们需要注意的是，
         * 虽然这个方法可以确保线程安全，但是在 迭代 时，我们仍然需要手动保证线程安全。
         * 就算在迭代时，我们使用了synchronized关键字，但是在 迭代过程 中，如果有其他线程对集合进行了修改，
         * 可能 会抛出ConcurrentModificationException异常。
         */

        // create a synchronized list
        List<Integer> numsList = Collections.synchronizedList(new ArrayList<>());
            // 添加初始数据
        for (int i = 0; i < 100; i++) {
            numsList.add(i);
        }

        // 创建一个线程用于迭代
        Thread iteratorThread = new Thread(() -> {
            synchronized (numsList) { // 使用迭代器时需要手动上锁
                for (Iterator<Integer> iterator = numsList.iterator(); iterator.hasNext(); ) {
                    System.out.println("Iterating: " + iterator.next());
                    try {
                        Thread.sleep(50); // 模拟迭代过程的延迟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 创建另一个线程用于修改集合
        Thread modifyThread = new Thread(() -> {
            try {
                Thread.sleep(50); // 等待迭代线程开始
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                numsList.add(9999); // 使用 add() 方法
                try {
                    Thread.sleep(50); // 模拟修改延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        iteratorThread.start();
        modifyThread.start();
        try{
            iteratorThread.join();
            modifyThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Threads finished");

    }
}
