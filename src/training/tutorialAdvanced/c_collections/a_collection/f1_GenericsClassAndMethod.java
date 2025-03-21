package training.tutorialAdvanced.c_collections.a_collection;

import java.util.ArrayList;
import java.util.List;

// 泛型类
// 自定义一个ArrayList类来模拟ArrayList
class MyList<E> {
    Object arr[] = new Object[10];
    int index = 0;
    int size = 0;
    public void add(E e){
        if (index == arr.length){ // 动态扩容
            Object[] newArr = new Object[(int)(arr.length * 1.5)];
            System.arraycopy(arr,0,newArr,0,arr.length);
            arr = newArr;
        }
        arr[index++] = e;
        size++;
    }
    // 使用可变参数，动态添加元素，不限制元素个数
    public void addAll(E...e){ // 此时e的类型是Object[]的数组
        for (E e1 : e) {
            add(e1);
        }
    }
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (E) arr[index];
    }
}


public class f1_GenericsClassAndMethod {
    // 泛型方法
    // 这个泛型方法可以在ArrayList中添加多个元素
    public static <T> void addAll(List<T> list, T...t){
        for (T tn : t){
            list.add(tn);
        }
    }

    public static void main(String[] args) {
        // 使用泛型类
        MyList<String> list = new MyList<>();
        list.addAll("Hello",",","World","!");
        System.out.println(list.get(0));
        System.out.println(list);
        // 使用泛型方法
        List<Integer> list2 = new ArrayList<>();
        addAll(list2,1,2,3,4,5);

    }
}
