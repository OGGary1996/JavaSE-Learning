package training.tutorialAdvanced.c_collections.a_collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class b1_Iterator {
    public static void main(String[] args) {
        List<String> demoList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));

        // 使用Iterator遍历集合, 适用于需要删除元素
            // 1.创建Iterator对象,通过Collection提供的iterator()方法获取，这个方法返回一个Iterator对象
        Iterator<String> iterator = demoList.iterator();
            // 2.使用hasNext()方法判断是否还有下一个元素,并且在循环中使用next()方法获取下一个元素
            // hasNext()方法返回的是指向元素的指针，从0开始；next()方法返回的是指针指向的元素，并且指针向后移动一位
        while(iterator.hasNext()){
            System.out.println("Element: " + iterator.next()); // 必须使用iterator提供的方法
        }

        /*
          方法：
        * hasNext()方法判断是否有下一个元素
        * next()方法用于返回元素并且将位置移动到下一个
            * 在循环当中只能调用一次next()方法，next()方法会移动一次指针；如果使用了多次next()，在循环快要结束时，第二个next()方法会移动到List范围外，所以会报错。
        细节：
        * 如果next（）方法指向了元素外，则会爆出NoSuchElementException。
        * 在遍历完成之后，指针不会复位；如果想再次遍历，需要重新获取新的Iterator。
        Pros&Cons
        * 优点：
            * 支持安全的删除元素
            * 适用于所有Collection
        * 缺点：
            * 只能单向遍历
            * 在操作元素时，只能使用Iterator自带的方法
            * 代码相对复杂
         */
    }
}
