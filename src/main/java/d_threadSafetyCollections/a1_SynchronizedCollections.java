package d_threadSafetyCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a1_SynchronizedCollections {
    public static void main(String[] args) {
        // create a normal list
            // 非线程安全
        // List<Integer> numsList = new ArrayList<>();
        // create a synchronized list
            // 线程安全
        List<Integer> numsList = Collections.synchronizedList(new ArrayList<>());

        Thread one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                numsList.add(i);
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                numsList.add(i);
            }
        });

        one.start();
        two.start();
        try{
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The size of the list is: " + numsList.size());

    }
}
