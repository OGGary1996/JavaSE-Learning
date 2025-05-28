package training.tutorialAdvanced.c_collections.a_collection;

// ArrayList的底层原理

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d_ArrayList {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
        /*
        1. 利用空参构造创建的集合，在底层首先创建一个默认容量为0的数组；
        2. 在添加第一个元素时，底层会创建一个容量为10的数组；
        3. 当这个容量为10的数组存满时，自动扩容1.5倍；
        4. 如果一次性添加的元素直接超过了容量，1.5倍还放不下，则新创建的数组以实际容量为准。
        */
    }
}
