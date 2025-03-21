package training.tutorialAdvanced.c_collections.a_collection;


// LinkedHashSet继承自HashSet，与HashSet的区别在于LinkedHashSet是有序的
// 如同HashSet在底层使用HashMap实现一样，LinkedHashSet在底层使用LinkedHashMap实现
// 区别在于，在LinkedHashMap中，除了储存Node<K,V>对象之外，还储存了一个指向前一个Node<K,V>对象的引用和一个指向后一个Node<K,V>对象的引用
// 这样就形成了一个双向链表，LinkedHashSet就是在这个基础上实现的。

import java.util.LinkedHashSet;

public class i_LinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> fruits = new LinkedHashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");
        fruits.add("Fig");
        fruits.add("Grape");
        fruits.add("Honeydew");
        System.out.println("LinkedHashSet: " + fruits);
    }
}
